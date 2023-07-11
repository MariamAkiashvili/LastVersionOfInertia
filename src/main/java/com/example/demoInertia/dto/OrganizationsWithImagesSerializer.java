package com.example.demoInertia.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.example.demoInertia.dto.OrganizationsWithImages;

import java.io.IOException;

public class OrganizationsWithImagesSerializer extends JsonSerializer<OrganizationsWithImages> {

    @Override
    public void serialize(OrganizationsWithImages organizationsWithImages, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("organization", organizationsWithImages.getOrganization());
        jsonGenerator.writeObjectField("base64Images", organizationsWithImages.getImages());
        jsonGenerator.writeEndObject();
    }
}
