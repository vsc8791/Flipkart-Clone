package com.vsc.darkhorse.repos;

import java.util.List;

import com.vsc.darkhorse.models.Product;


public interface ProductRepo {

	List<Product> get();

	Product get(String unique_id);

	String save(Product product);

	String delete(String unique_id);

	String update(Product product, String unique_id);
	
	String loadDatabase(List<Product> listOfProducts);

	List<Product> getByRating(String rating);

}
