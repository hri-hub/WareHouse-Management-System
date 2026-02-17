package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;
    
    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    
    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }
    
    @Override
    public Category updateCategory(Long id, Category category) {
        category.setCategoryId(id);
        return categoryRepo.save(category);
    }
    
    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
    
    @Override
    public Page<Category> getCategoriesWithPagination(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }
}