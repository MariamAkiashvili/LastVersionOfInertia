package com.example.demoInertia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoInertia.model.Category;
import com.example.demoInertia.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(boolean isActive) {
        List <Category> categories = categoryRepository.findByIsActive(true);
        return categories;
    }

    @Override
    public List<Category> getAgeRestrictedCategories(boolean isAgeControled) {
        List <Category> categories = categoryRepository.findByIsAgeControled(isAgeControled);
        return categories;
    }

    
}