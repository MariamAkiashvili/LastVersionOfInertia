package com.example.demoInertia.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demoInertia.model.Reservations;
import com.example.demoInertia.model.ReservedTables;

public interface BookingService {

    List<Reservations> getAll(boolean isVisited);

    Reservations getReservationById(int id);

    ResponseEntity <String> booking(Reservations reservations, List<ReservedTables> reservedTables);
    
}
