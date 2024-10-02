package com.jsp.service;

import java.util.List;
import java.util.Optional;

import com.jsp.entity.Product;

public interface ProductService {
	    List<Product> getAllProducts();
	    Optional<Product> getProductById(Long id);  
	    Product createProduct(Product product);
	    Optional<Product> updateProduct(Long id, Product productDetails);
	    Product deleteProduct(Long id);
	    Optional<Product> getProductByName(String name);// this is my custom method
	    Optional<Product> getProductByPrice(Double price);
		
	  
	}

	


