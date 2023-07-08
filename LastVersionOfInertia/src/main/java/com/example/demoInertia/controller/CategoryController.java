package com.example.demoInertia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demoInertia.model.Category;
import com.example.demoInertia.service.CategoryService;

@RestController
@RequestMapping("/Category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getCategories")
    public List <Category> getCategories(){
        return categoryService.getAllCategories(true);

    }
    @GetMapping("/getAgeControledCategories")
    public List <Category> getAgeControledCategories(@RequestHeader boolean isAgeControled){
        return categoryService.getAgeRestrictedCategories(isAgeControled);

    }

}
