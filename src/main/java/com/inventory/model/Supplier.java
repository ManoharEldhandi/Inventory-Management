package com.inventory.model;

public class Supplier {

    private int id;
    private String name;
    private String contactInfo;

    // Constructor
    public Supplier(int id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Display supplier details
    @Override
    public String toString() {
        return "Supplier ID: " + id + ", Name: " + name + ", Contact Info: " + contactInfo;
    }
}
