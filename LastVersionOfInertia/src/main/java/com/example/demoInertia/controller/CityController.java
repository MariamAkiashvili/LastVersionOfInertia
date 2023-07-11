package com.example.demoInertia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoInertia.model.City;
import com.example.demoInertia.service.CityService;

@RestController
@RequestMapping("/City")
@CrossOrigin
public class CityController {
    
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }
}
