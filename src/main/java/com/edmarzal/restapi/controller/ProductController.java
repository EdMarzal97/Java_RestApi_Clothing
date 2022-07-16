package com.edmarzal.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edmarzal.restapi.model.Product;
import com.edmarzal.restapi.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    
    //TODO
    //This will CREATE a new Product on the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){

        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    } 

    //This will GET a Product by the ID

    //This will GET all the Products

    //This will UPDATE a Product

    //This will DELETE a Product

    //This allow to get a Product by the name USING RAW SQL STATEMENTS
}
