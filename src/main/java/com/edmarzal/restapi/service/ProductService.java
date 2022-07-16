package com.edmarzal.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edmarzal.restapi.dao.ProductRepository;
import com.edmarzal.restapi.model.Product;


@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    } 

}
