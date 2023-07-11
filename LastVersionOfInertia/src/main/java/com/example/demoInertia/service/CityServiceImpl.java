package com.example.demoInertia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoInertia.model.City;
import com.example.demoInertia.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;



    @Override
    public List<City> getAllCities() {
        return cityRepository.findByIsActive(true);
    }
    
}
