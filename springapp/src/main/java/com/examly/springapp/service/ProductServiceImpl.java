package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepo productRepo;
    
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    
    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
    
    @Override
    public Product updateProduct(Long id, Product product) {
        product.setProductId(id);
        return productRepo.save(product);
    }
    
    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
    
    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepo.findByCategoryName(categoryName);
    }
    
    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepo.findByProductName(productName);
    }
}