package com.example.demoInertia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.model.Images;

public interface UploadImageRepository extends JpaRepository <Images, Integer>{
//     public APIResponse saveImageAddress(Images image);
}
