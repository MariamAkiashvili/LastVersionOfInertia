package com.example.demoInertia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoInertia.model.Reservations;
import com.example.demoInertia.model.ReservedTables;
import com.example.demoInertia.repository.BookingRepository;
import com.example.demoInertia.repository.ReservedTablesRepository;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ReservedTablesRepository reservedTablesRepository;

    @Override
    public List<Reservations> getAll(boolean isVisited) {
        return bookingRepository.findByIsVisited(isVisited);
    }

    @Override
    public Reservations getReservationById(int id) {
        return bookingRepository.findById(id);
    }

    @Override
    public ResponseEntity <String> booking(Reservations reservations, List<ReservedTables> reservedTables) {
        
        try {
            bookingRepository.save(reservations);
            for (int i=0; i<reservedTables.size(); i++){
                reservedTablesRepository.save(reservedTables.get(i));
            }
            return ResponseEntity.ok("Booked successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred while creating the record");
        } 
        
    }
    
}
