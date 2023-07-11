package com.example.demoInertia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoInertia.service.ImageService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/Upload")
@CrossOrigin
public class UploadOrganizationImagesController {

    @Autowired 
    ImageService imageService;
    
    @PostMapping("/Image")
    public String handleImageUpload( @RequestParam("organizationId") int organizationId, 
                                    @RequestParam("files") MultipartFile[] file) throws IOException{


        // int id = Integer.parseInt(StringOrganizationId);
        for (MultipartFile f : file){
            imageService.uploadFile(f, organizationId);
        }
        
        return "Upload completed successfully";
    }

    @GetMapping("GetImages")
    public  ResponseEntity<List<Resource>> getImagesById(@RequestParam int id){
        return null; 
        
        
    }
}
