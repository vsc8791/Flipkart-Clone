package com.vsc.darkhorse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsc.darkhorse.models.Product;
import com.vsc.darkhorse.repos.ProductRepo;
import com.vsc.darkhorse.utils.DataUtils;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> get() {
		return productRepo.get();
	}

	@Override
	public Product get(String unique_id) {
		return productRepo.get(unique_id);
	}

	@Override
	public String save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public String delete(String unique_id) {
		return productRepo.delete(unique_id);
	}

	@Override
	public String update(Product product, String unique_id) {
		return productRepo.update(product, unique_id);
	}

	@Override
	public String loadDatabase() {
		List<Product> listOfProducts = DataUtils.getListsOfProducts();
		return productRepo.loadDatabase(listOfProducts);
	}

	@Override
	public List<Product> getByRating(String rating) {
		
		return productRepo.getByRating(rating);
	}
	

}
