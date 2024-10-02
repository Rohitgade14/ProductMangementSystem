package com.jsp.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.jsp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
         	Optional<Product> findByName(String name);
         	Optional<Product> findByPrice(double price);

}
