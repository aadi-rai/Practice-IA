package org.example;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    private String username;
    private int numTickets;
    private double totalCost;
    private Event event;

    private String additionalDetails; // Input from comments box (e.g. age of attendees)

    private long cardNumber;
    private LocalDate expiryDate;
    private short CCV;


    public Booking(String bookingID, String username, int numTickets, double totalCost,
                   String additionalDetails, long cardNumber, LocalDate expiryDate, short CCV) {
        this.bookingID = bookingID;
        this.username = username;
        this.numTickets = numTickets;
        this.totalCost = totalCost;

        this.additionalDetails = additionalDetails;

        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.CCV = CCV;
    }

    //<editor-fold desc="getters/setters">
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public short getCCV() {
        return CCV;
    }

    public void setCCV(short CCV) {
        this.CCV = CCV;
    }
    //</editor-fold>
}
