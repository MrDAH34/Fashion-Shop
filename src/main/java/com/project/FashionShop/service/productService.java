package com.project.FashionShop.service;

import java.util.List;

import com.project.FashionShop.model.Product;

public interface productService {
    public List<Product> listAllProduct();

    public Product saveProduct(Product product);

    public Product findById(Long productId);

    public void deleteById(Long productID);

    public void updateProduct(Product product);

    public List<Product> searchByName(String name);
}
