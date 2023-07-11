package com.example.demoInertia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demoInertia.dto.OrganizationParams;
import com.example.demoInertia.model.Organization;
import com.example.demoInertia.service.OrganizationService;

@RestController
@RequestMapping("/Organizations")
@CrossOrigin
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/getAllOrganizations")
    public List<Organization> getAllOrganizations(){
        return organizationService.getAllOrganization();
    }
    // @GetMapping("/getFilterdOrganizationList")
    // public List<Organization> getFilteredOrganizationList(@RequestParam OrganizationParams params){
    //     return organizationService.getFilteredOrganizations(params);
    // }
    @GetMapping("/organizations")
    public List<Organization> getOrganizations(@RequestParam(required = false) Map<String, String> filters){
        return organizationService.organizations(filters);
    }
}
