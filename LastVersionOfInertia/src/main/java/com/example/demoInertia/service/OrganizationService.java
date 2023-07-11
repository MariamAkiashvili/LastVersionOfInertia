package com.example.demoInertia.service;

import java.util.List;
import java.util.Map;

import com.example.demoInertia.model.Organization;

public interface OrganizationService {
    public List<Organization> getAllOrganization();
    public List<Organization> organizations(Map<String,String> filters);
    public Organization getOrganizationById(int Id);
    
}
