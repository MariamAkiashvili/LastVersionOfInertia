package com.example.demoInertia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoInertia.model.City;



public interface CityRepository extends JpaRepository <City, Integer>{

    List<City> findByIsActive(boolean b);
    
}
