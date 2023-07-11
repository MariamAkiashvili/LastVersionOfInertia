package com.example.demoInertia.repository;

import com.example.demoInertia.model.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository <Category, Integer>{

    List<Category> findByIsActive(boolean b);

    List<Category> findByIsAgeControled(boolean b);
    
}
