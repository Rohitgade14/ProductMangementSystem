package com.jsp.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.entity.Product;
import com.jsp.exception.ProductNotFoundException;
import com.jsp.respository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

	
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setDescription(productDetails.getDescription());
            return Optional.of(productRepository.save(product));
        }).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    public Product deleteProduct(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return product;
                })
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
          }

	
        public Optional<Product> getProductByName(String name) {
		
		return productRepository.findByName(name);
		
	    }

	
		public Optional<Product> getProductByPrice(Double price) {
			return productRepository.findByPrice(price);
		}
	
   
	
	
    
}
