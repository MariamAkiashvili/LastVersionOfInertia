package com.example.demoInertia.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoInertia.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository <Organization, Integer>{

    List<Organization> findByIsActive(boolean b);
    Organization findById(int id);
    
}
