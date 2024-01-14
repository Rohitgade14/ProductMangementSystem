package com.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Entity.Product;

public interface ProductRepostiory  extends JpaRepository<Product, Integer> {
	public List<Product> findBypriceGreaterThan(double price);
    public List<Product> findBypriceLessThan(double price);
    public List<Product> findByBrand(String brand);
    public List<Product> findByWarrenty(int warrenty);

}
