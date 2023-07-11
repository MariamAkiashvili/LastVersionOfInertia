package com.example.demoInertia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demoInertia.model.Organization;

import org.springframework.core.io.Resource;

// import com.example.demoInertia.model.Organization;


public interface ImageService {
    public void uploadFile(MultipartFile file, int organizationId) throws IOException;
    //public List<Resource> getImagesByOrganization(int Id);
}
