package com.example.demoInertia.service;
import java.util.List;

import com.example.demoInertia.model.Category;


public interface CategoryService {

    public List<Category> getAllCategories(boolean isActive);
    public List<Category> getAgeRestrictedCategories(boolean isAgeControled);
}
