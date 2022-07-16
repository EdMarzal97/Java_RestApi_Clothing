package com.edmarzal.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edmarzal.restapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
