package com.edmarzal.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edmarzal.restapi.model.Product;
import com.edmarzal.restapi.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // This will CREATE a new Product on the database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

    // This will GET a single Product by the ID
    @GetMapping("/id")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId") long productId) {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // This will GET all the Products
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // This will UPDATE a Product
    @PatchMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId") long productId,
            @RequestBody Product product) {
        Product updatedProduct = productService.updatedProduct(productId, product);
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    // This will DELETE a Product
    @DeleteMapping("/")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "productId") long productId) {
        Product deletedProduct = productService.deletedProduct(productId);
        return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
    }

    // This allow to get a Product by the name USING RAW SQL STATEMENTS
    @GetMapping("/products-by-name")
    public List<Product> getProductsByName(@RequestParam(name = "productName") String productName) {
        return productService.getProductsByName(productName);
    }
}

// INVESTIGATE INNER JOINS AND JOINS ON MYSQL
// MANY TO MANY KEYS TOO
// WHAT HAPPEN WHEN I WANNA ORDER MANY PRODUCTS AT THE SAME CLIENT?