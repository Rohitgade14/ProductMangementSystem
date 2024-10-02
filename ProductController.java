package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.entity.Product;
import com.jsp.exception.ProductNotFoundException;
import com.jsp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired 
	ProductService productService;
	
	@GetMapping
	public  ResponseEntity <List<Product>> getAllProduct() {
		 List<Product> products = productService.getAllProducts();
	        return ResponseEntity.ok(products);
	}
     @GetMapping("{/id}")
     public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    	 Product product = productService.getProductById(id)
    			 .orElseThrow(() ->new ProductNotFoundException("Product not found with id " + id));
    	    return ResponseEntity.ok(product);
	}
	@PostMapping
     public ResponseEntity<Product> createProduct(@RequestBody Product product) {
         Product savedProduct = productService.createProduct(product);
         return ResponseEntity.ok(savedProduct);
     }
     @PutMapping("/{id}")
     public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
         Product updatedProduct = productService.updateProduct(id, productDetails)
             .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
         return ResponseEntity.ok(updatedProduct);
     }
     @DeleteMapping("/{id}")
     public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
         Product deletedProduct = productService.deleteProduct(id);
         return ResponseEntity.ok(deletedProduct);
     }
     
     @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		  Product product = productService.getProductByName(name)
		  .orElseThrow(() -> new ProductNotFoundException ("Product not found with name "+name));
		  return ResponseEntity.ok(product);
     }
     
     @GetMapping("/price/{price}")
     public ResponseEntity<Product> getProductByPrice(@PathVariable Double price) {
    	   Product product = productService.getProductByPrice(price)
    			.orElseThrow(() -> new ProductNotFoundException("Product not found with price "+price));
         return ResponseEntity.ok(product);
	}
    	 
		
	
}
