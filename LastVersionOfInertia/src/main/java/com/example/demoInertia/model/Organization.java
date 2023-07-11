package com.example.demoInertia.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Organization {
    

    @Id 
    @GeneratedValue(strategy =GenerationType.IDENTITY)

    private int id;
    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private City city;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;

    private boolean isAgeControlled;
    private boolean isPetFriendly;
    private boolean isPWDAdapted;
    private boolean open24;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate addedDate;

    

    public boolean isOpen24() {
        return open24;
    }

    public void setOpen24(boolean open24) {
        this.open24 = open24;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate() {
        this.addedDate = LocalDate.now();
    }

    public boolean isAgeControlled() {
        return isAgeControlled;
    }

    public void setAgeControlled(boolean isAgeControlled) {
        this.isAgeControlled = isAgeControlled;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    public void setPetFriendly(boolean isPetFriendly) {
        this.isPetFriendly = isPetFriendly;
    }

    public boolean isPWDAdapted() {
        return isPWDAdapted;
    }

    public void setPWDAdapted(boolean isPWDAdapted) {
        this.isPWDAdapted = isPWDAdapted;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
