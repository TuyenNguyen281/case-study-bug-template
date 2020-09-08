package com.codegym.service.impl;


import com.codegym.model.Category;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne( id );
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
