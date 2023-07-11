package com.example.demoInertia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tables {
        

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Organization organization;
    private String tableNo;
    private int guestNumber;
    

    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Organization getOrganization() {
        return organization;
    }
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    public String getTableNo() {
        return tableNo;
    }
    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }
    public int getGuestNumber() {
        return guestNumber;
    }
    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }
    
}
