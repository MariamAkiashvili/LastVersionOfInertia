package com.example.demoInertia.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private boolean isAgeControled;

    @Column (columnDefinition = "boolean default true")
    private boolean isActive;

    // @OneToMany
    // private List <Organization> organizations;
    
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    private String name;




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isAgeControled() {
        return isAgeControled;
    }
    public void setAgeControled(boolean isAgeControled) {
        this.isAgeControled = isAgeControled;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
