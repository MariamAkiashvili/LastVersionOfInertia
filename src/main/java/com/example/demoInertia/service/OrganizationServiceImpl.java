package com.example.demoInertia.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.example.demoInertia.dto.OrganizationsWithImages;
import com.example.demoInertia.model.Images;
import com.example.demoInertia.model.Organization;
import com.example.demoInertia.repository.ImagesRepository;
import com.example.demoInertia.repository.OrganizationRepository;



@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public List<OrganizationsWithImages> getAllOrganization() {

        List<OrganizationsWithImages> orgs = new ArrayList<>();

        for (Organization organization : organizationRepository.findByIsActive(true)) {

            OrganizationsWithImages organizationWithImages = new OrganizationsWithImages(organization);
            List <Images> images = imagesRepository.findAllByOrganization(organization);

            for (Images image : images) {

                try {
                    Path imagePath = Paths.get(image.getAddress());
                    Resource resource = new UrlResource(imagePath.toUri());

                    if (resource.exists()) {
                        byte[] imageData = FileCopyUtils.copyToByteArray(resource.getInputStream());
                        String base64Image = Base64.getEncoder().encodeToString(imageData);
                        organizationWithImages.AddImages(base64Image);
                    }

                } 
                catch (IOException e) {
                // Handle exception if unable to read image file
                }
            }
            orgs.add(organizationWithImages);
            
        }
       return orgs;
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
