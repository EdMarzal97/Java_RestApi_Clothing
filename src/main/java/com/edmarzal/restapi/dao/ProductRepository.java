package com.edmarzal.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edmarzal.restapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Products WHERE product_name = ?1", nativeQuery = true)
    List<Product> getProductsByName(String productName);
    
}
