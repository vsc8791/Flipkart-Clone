package com.vsc.darkhorse.services;

import java.util.List;

import com.vsc.darkhorse.models.Product;

public interface ProductService {

	List<Product> get();

	Product get(String unique_id);

	String save(Product product);

	String delete(String unique_id);

	String update(Product product, String unique_id);
	
	String loadDatabase();

	List<Product> getByRating(String rating);

}
