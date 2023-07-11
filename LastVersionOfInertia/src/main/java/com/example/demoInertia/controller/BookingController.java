package com.example.demoInertia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoInertia.model.Reservations;
import com.example.demoInertia.model.ReservedTables;
import com.example.demoInertia.service.BookingService;

@RestController
@RequestMapping("/Booking")
@CrossOrigin
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @GetMapping("/get")
    public List <Reservations> getAllReservations(@RequestParam (required = false) boolean isVisited){
        return bookingService.getAll(isVisited);
    }

    @GetMapping("/getReservation")
    public Reservations getReservation (@RequestParam int id){
        return bookingService.getReservationById(id);
    }

    @PostMapping("/booking")
    public ResponseEntity <String> booking(@RequestBody Reservations reservations, List<ReservedTables> reservedTables){
        

        return bookingService.booking(reservations, reservedTables);
        
    }

}
