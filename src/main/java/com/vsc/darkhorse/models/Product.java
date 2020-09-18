package com.vsc.darkhorse.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "unique_id", length = 512)
	private String unique_id;

	@Column(name = "productUrl", length = 512)
	private String productUrl;

	@Column(name = "productName", length = 512)
	private String productName;

	@Column(name = "pid", length = 512)
	private String pid;

	@Column(name = "productCategoryTree", length = 100000)
	private String productCategoryTree;

	@Column(name = "retailPrice",length = 512)
	private String retailPrice;

	@Column(name = "discountedPrice", length = 512)
	private String discountedPrice;

	@Column(name = "image", length = 100000)
	private String image;

	@Column(name = "isFKAdvantageProduct", length = 10)
	private String isFKAdvantageProduct;

	@Column(name = "description", length = 100000)
	private String description;

	@Column(name = "productRating", length = 512)
	private String productRating;

	@Column(name = "overallRating", length = 512)
	private String overallRating;

	@Column(name = "brand", length = 512)
	private String brand;

	public Product() {
	}

	public Product(String unique_id, String productUrl, String productName, String pid, String productCategoryTree,
			String retailPrice, String discountedPrice, String image, String isFKAdvantageProduct, String description,
			String productRating, String overallRating, String brand) {
		super();
		this.unique_id = unique_id;
		this.productUrl = productUrl;
		this.productName = productName;
		this.pid = pid;
		this.productCategoryTree = productCategoryTree;
		this.retailPrice = retailPrice;
		this.discountedPrice = discountedPrice;
		this.image = image;
		this.isFKAdvantageProduct = isFKAdvantageProduct;
		this.description = description;
		this.productRating = productRating;
		this.overallRating = overallRating;
		this.brand = brand;
	}

	public String getUnique_id() {
		return unique_id;
	}

	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getProductCategoryTree() {
		return productCategoryTree;
	}

	public void setProductCategoryTree(String productCategoryTree) {
		this.productCategoryTree = productCategoryTree;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(String discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsFKAdvantageProduct() {
		return isFKAdvantageProduct;
	}

	public void setIsFKAdvantageProduct(String isFKAdvantageProduct) {
		this.isFKAdvantageProduct = isFKAdvantageProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductRating() {
		return productRating;
	}

	public void setProductRating(String productRating) {
		this.productRating = productRating;
	}

	public String getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [unique_id=" + unique_id + ", productUrl=" + productUrl + ", productName=" + productName
				+ ", pid=" + pid + ", productCategoryTree=" + productCategoryTree + ", retailPrice=" + retailPrice
				+ ", discountedPrice=" + discountedPrice + ", image=" + image + ", isFKAdvantageProduct="
				+ isFKAdvantageProduct + ", description=" + description + ", productRating=" + productRating
				+ ", overallRating=" + overallRating + ", brand=" + brand + "]";
	}

}
