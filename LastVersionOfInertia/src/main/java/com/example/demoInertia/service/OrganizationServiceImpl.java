package com.example.demoInertia.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoInertia.model.Organization;
import com.example.demoInertia.repository.OrganizationRepository;



@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;


    @Override
    public List<Organization> getAllOrganization() {
       return organizationRepository.findByIsActive(true);
    }


    @Override
    public List<Organization> organizations(Map<String, String> filters) {
        List<Organization> organizationsList = organizationRepository.findByIsActive(true);
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            String key = filter.getKey();
            String value = filter.getValue();
    
            switch (key) {
                case "name":
                    organizationsList = organizationsList.stream().filter(organization -> organization.getName().equals(value)).collect(Collectors.toList());
                    break;
                case "isAgeControlled":
                    if(Boolean.parseBoolean(value)==true){
                        organizationsList = organizationsList.stream().filter(organization -> organization.isAgeControlled() == Boolean.parseBoolean(value)).collect(Collectors.toList());
                    }
                    break;
                case "isPetFriendly":
                    if(Boolean.parseBoolean(value)==true){
                        organizationsList = organizationsList.stream().filter(organization -> organization.isPetFriendly()==Boolean.parseBoolean(value)).collect(Collectors.toList());
                    }
                    break;
                case "isPWDAdapted":
                    if(Boolean.parseBoolean(value)==true){
                        organizationsList = organizationsList.stream().filter(organization -> organization.isPWDAdapted()==Boolean.parseBoolean(value)).collect(Collectors.toList());
                    }
                    break;
                case "open24":
                    if(Boolean.parseBoolean(value)==true){
                        organizationsList = organizationsList.stream().filter(organization -> (organization.isOpen24()==Boolean.parseBoolean(value))).collect(Collectors.toList());
                    }
                    break;
                case "openNow":
                    if (Boolean.parseBoolean(value)==true){
                        organizationsList = organizationsList.stream().
                                                    filter(organization ->
                                                                ((organization.getEndTime().isBefore(organization.getStartTime()) &&
                                                                        (LocalTime.now().isAfter(organization.getStartTime()) || LocalTime.now().isBefore(organization.getEndTime())))
                                                                    ||
                                                                (organization.getEndTime().isAfter(organization.getStartTime()) &&  
                                                                    (LocalTime.now().isAfter(organization.getStartTime()) && LocalTime.now().isBefore(organization.getEndTime())))))
                                                                    .collect(Collectors.toList());
                        
                    }
                    break;


                default:
                    // do nothing
                    
            }
        }
    
        return organizationsList;
    }

    @Override
    public Organization getOrganizationById(int id){
        return organizationRepository.findById(id);

    }

}
