package com.example.demoInertia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoInertia.model.Reservations;

public interface BookingRepository extends JpaRepository <Reservations, Integer>{

    List <Reservations> findByIsVisited(boolean isVisited);
    Reservations findById(int id);
}
