package com.project.FashionShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FashionShop.model.Product;

import com.project.FashionShop.repository.productRepository;

import com.project.FashionShop.service.productService;

@Service
public class productServiceImpl implements productService {
    @Autowired
    private productRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long productID) {
        productRepository.deleteById(productID);
        ;
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.findByName(name);
    }

}
