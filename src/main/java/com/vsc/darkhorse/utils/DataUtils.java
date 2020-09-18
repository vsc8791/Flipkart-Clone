package com.vsc.darkhorse.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.vsc.darkhorse.models.Product;

public class DataUtils {
	private final static String CSV_FILE_NAME = "flipkartProductWithimages";
	private final static String CSV_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "data" + File.separator + CSV_FILE_NAME
			+ ".xlsx";

//	public static void main(String[] args) {
//
//		List<Product> list = getListsOfProducts();
//		for (Product product : list) {
//			System.out.println(product.toString());
//		}
//	}

	public static List<Product> readData() {
		List<Product> products = new ArrayList<Product>();
		try {
			FileReader fileReader = new FileReader(new File(CSV_FILE_PATH));
			CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
			Product product = new Product();
			List<String[]> allData = csvReader.readAll();
			for (String[] row : allData) {
				product.setUnique_id(row[0]);
				product.setProductUrl(row[1]);
				product.setProductName(row[2]);
				product.setPid(row[3]);
				product.setProductCategoryTree(row[4]);
				product.setRetailPrice(row[5]);
				product.setDiscountedPrice(row[6]);
				product.setImage(row[7]);
				product.setIsFKAdvantageProduct(row[8]);
				product.setDescription(row[9]);
				product.setProductRating(row[10]);
				product.setOverallRating(row[11]);
				product.setBrand(row[12]);

				products.add(product);
			}

		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
		return products;
	}

	public static String handleStringConversion(Object object) {
		String value = null;

		if (object.equals(null))
			value = "0";
		else if (object instanceof Integer)
			value = String.valueOf(object);
		else
			value = object.toString();
		return value;
	}

	public static List<Product> getListsOfProducts() {
		List<Product> listOfProducts = new ArrayList<Product>();
		try {
			FileInputStream file = new FileInputStream(new File(CSV_FILE_PATH));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("products");
			int numberOfRows = sheet.getLastRowNum();
			
			for (int i = 1; i <= numberOfRows; i++) {
				Product product = new Product();
				product.setUnique_id(handleStringConversion(sheet.getRow(i).getCell(0).getStringCellValue()));
				product.setProductUrl(handleStringConversion(sheet.getRow(i).getCell(1).getStringCellValue()));
				product.setProductName(handleStringConversion(sheet.getRow(i).getCell(2).getStringCellValue()));
				
				product.setProductCategoryTree(
						handleStringConversion(sheet.getRow(i).getCell(3).getCellType() == CellType.NUMERIC
								? String.valueOf(sheet.getRow(i).getCell(3).getNumericCellValue())
								: sheet.getRow(i).getCell(3).getStringCellValue()));
				product.setPid(handleStringConversion(sheet.getRow(i).getCell(4).getStringCellValue()));
				product.setRetailPrice(
						handleStringConversion(sheet.getRow(i).getCell(5).getCellType() == CellType.NUMERIC
								? String.valueOf(sheet.getRow(i).getCell(5).getNumericCellValue())
								: sheet.getRow(i).getCell(5).getStringCellValue()));
				product.setDiscountedPrice(
						handleStringConversion(sheet.getRow(i).getCell(6).getCellType() == CellType.NUMERIC
								? String.valueOf(sheet.getRow(i).getCell(6).getNumericCellValue())
								: sheet.getRow(i).getCell(6).getStringCellValue()));
				product.setImage(handleStringConversion(sheet.getRow(i).getCell(7).getStringCellValue()));
				product.setIsFKAdvantageProduct(
						handleStringConversion(sheet.getRow(i).getCell(8).getStringCellValue()));
				product.setDescription(handleStringConversion(sheet.getRow(i).getCell(9).getStringCellValue()));
				product.setProductRating(
						handleStringConversion(sheet.getRow(i).getCell(10).getCellType() == CellType.NUMERIC
								? String.valueOf(sheet.getRow(i).getCell(10).getNumericCellValue())
								: sheet.getRow(i).getCell(10).getStringCellValue()));
				product.setOverallRating(
						handleStringConversion(sheet.getRow(i).getCell(11).getCellType() == CellType.NUMERIC
								? String.valueOf(sheet.getRow(i).getCell(11).getNumericCellValue())
								: sheet.getRow(i).getCell(11).getStringCellValue()));
				product.setBrand(handleStringConversion(sheet.getRow(i).getCell(12).getStringCellValue() == null ? ""
						: sheet.getRow(i).getCell(12).getStringCellValue()));

				listOfProducts.add(product);
			}

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfProducts;

	}

}