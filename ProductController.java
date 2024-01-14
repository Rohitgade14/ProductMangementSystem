package com.jsp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Entity.Product;
import com.jsp.repository.ProductRepostiory;
@RestController
public class ProductController {
	@Autowired ProductRepostiory productrepostiory;
	@PostMapping("/post")
	public String m1() 
	{
		return "hello Product";
	}
    @GetMapping("/get")
	public String m2()
	{
		return "get product";
		
	}
    @PostMapping("/saveproduct")
    public Product saveProduct(@RequestBody Product product) {
    	productrepostiory.save(product);
		return product;
	}
    @GetMapping("/fetchproduct")
    public Product fetchProduct(@RequestParam int id) {
		Optional<Product> optional=productrepostiory.findById(id);
		Product product =optional.get();
		return product;
	}
    
    @DeleteMapping("/deleteproduct")
    public String name(@RequestParam int id) {
	    productrepostiory.findById(id);
    	return "product deleted";
	}
    @GetMapping("/greaterthan")
	 public List<Product> FetchProductByPriceGreaterThan(@RequestParam double price)
	 {
			 return productrepostiory.findBypriceGreaterThan(price);
			  
		 }
	@GetMapping("/lessthan")
	 public List<Product> fetchproProductByPriceLessThan(@RequestParam double price) 
	 {
		 return productrepostiory.findBypriceLessThan(price);
		
	}
	@GetMapping("/findBybrand")
	 public List<Product> fetchProductByBrand(@RequestParam String brand)
	 {
		 return productrepostiory.findByBrand(brand);
		 
		
	 }
	 
	 @GetMapping("/findBywarrentay")
	 public List<Product> fetchProductByWarrentay(@RequestParam int warrenty)
	 {
		 return productrepostiory.findByWarrenty(warrenty);
	 }
}
