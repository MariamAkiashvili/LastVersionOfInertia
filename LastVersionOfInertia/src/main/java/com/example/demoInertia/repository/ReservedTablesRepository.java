package com.example.demoInertia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoInertia.model.ReservedTables;

public interface ReservedTablesRepository extends JpaRepository <ReservedTables, Integer>{
    
    
}
