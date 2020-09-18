package com.vsc.darkhorse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vsc.darkhorse.models.Product;
import com.vsc.darkhorse.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/loadDb")
	private String loadDatabases() {
		return productService.loadDatabase();
	}

	@SuppressWarnings("unused")
	@GetMapping("/products")
	private ResponseEntity<List<Product>> findAllProducts(){
		return new ResponseEntity<List<Product>>(productService.get(), HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/products/{id}")
	private ResponseEntity<Product> findById(@PathVariable(value = "id") String unique_id){
		return new ResponseEntity<Product>(productService.get(unique_id), HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/products/rating/{rating}")
	private ResponseEntity<List<Product>> getByRating(@PathVariable(value = "rating") String rating){
		return new ResponseEntity<List<Product>>(productService.getByRating(rating), HttpStatus.OK);
	}
}
