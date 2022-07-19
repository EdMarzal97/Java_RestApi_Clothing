package com.edmarzal.restapi.service;

import java.util.List;

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

    public Product getProduct(long productId){
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("error 404"));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    } 

    public Product updatedProduct(long productId, Product product){
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("error 404"));
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setSize(product.getSize());
        existingProduct.setColor(product.getColor());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setIs_in_sale(product.getIs_in_sale());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public Product deletedProduct(long productId){
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("error 404"));
        productRepository.deleteById(productId);
        return existingProduct;
    }

    public List<Product> getProductsByName(String productName){
        return productRepository.getProductsByName(productName);
    }

}
