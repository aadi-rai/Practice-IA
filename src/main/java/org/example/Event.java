package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class Event implements Serializable  {
    private String eventID;
    private LocalDate date;
    private String location;
    private int capacity;
    private double price;
    private boolean available;


    public Event(String eventID, LocalDate date, String location, int capacity,
                 double price, boolean available) {
        this.eventID = eventID;
        this.date = date;
        this.location = location;
        this.capacity = capacity;
        this.price = price;
        this.available = available;
    }

    //<editor-fold desc="getters/setters">
    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    //</editor-fold>
}
