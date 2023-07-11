package com.example.demoInertia.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoInertia.model.Images;
import com.example.demoInertia.model.Organization;
import com.example.demoInertia.repository.OrganizationRepository;
// import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.repository.UploadImageRepository;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private UploadImageRepository uploadImageRepository;

    @Autowired
    private OrganizationRepository org;
    @Override
    public void uploadFile(MultipartFile file, int organizationId) throws IOException {

        

        String uploadDir ="D:/Users/User/Documents/DemoInertiaImages";


        String fileName = UUID.randomUUID().toString() + ".jpg";
        Path filePath = Paths.get(uploadDir, fileName);
        Files.createDirectories(filePath.getParent());

        // Save the uploaded file to the new file location
        InputStream inputStream = file.getInputStream();
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        // Save the file path in your database
        String imagePath = filePath.toAbsolutePath().toString();

        Images image = new Images();
        image.setAddress(imagePath);
        image.setName(fileName);

        //Select Organization by Id
        image.setOrganization(org.findById(organizationId));

        uploadImageRepository.save(image);
         

        // return (new APIResponse());

    }
    // @Override
    // public List<Resource> getImagesByOrganization(int Id) {
    //     uploadImageRepositor
    // }
    
}
