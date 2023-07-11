package com.example.demoInertia.dto;

import java.util.ArrayList;
import java.util.List;

//import com.example.demoInertia.model.Images;
import com.example.demoInertia.model.Organization;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = OrganizationsWithImagesSerializer.class)

public class OrganizationsWithImages {
    
    private Organization organization;
    private List<String> images = new ArrayList<> ();

    public OrganizationsWithImages(Organization organization){
        this.organization = organization;
        //this.images = images;
    }


    public String AddImages(String image){
        
        try {
            images.add(image);
            return "ok";

        } catch (Exception e) {
            return "400";
        }
        
    }

    public Organization getOrganization(){
        return this.organization;
    }

    public List<String> getImages(){
        return this.images;
    }






}
