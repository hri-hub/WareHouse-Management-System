package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getProductsByCategoryName(String categoryName);
    List<Product> getProductsByName(String productName);
}