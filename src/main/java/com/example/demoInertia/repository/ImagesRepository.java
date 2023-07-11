package com.example.demoInertia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.model.Images;
import com.example.demoInertia.model.Organization;
//import com.example.demoInertia.service.Image;

public interface ImagesRepository extends JpaRepository <Images, Integer>{

    List<Images> findAllByOrganization(Organization organization);
//     public APIResponse saveImageAddress(Images image);



}
