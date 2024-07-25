package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String password;

    private String firstName;
    private String surname;

    private String streetAddress;
    private String citySuburb;
    private short postCode;

    private long phoneNumber;
    private boolean isAdmin;
    private final ArrayList<Booking> bookings;


    public User(String username, String password, String firstName, String surname, String streetAddress,
                String citySuburb, short postCode, long phoneNumber, boolean isAdmin) {
        this.username = username;
        this.password = password;

        this.firstName = firstName;
        this.surname = surname;

        this.streetAddress = streetAddress;
        this.citySuburb = citySuburb;
        this.postCode = postCode;

        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        bookings = new ArrayList<Booking>();
    }

    //<editor-fold desc="getters/setters">
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCitySuburb() {
        return citySuburb;
    }

    public void setCitySuburb(String citySuburb) {
        this.citySuburb = citySuburb;
    }

    public short getPostCode() {
        return postCode;
    }

    public void setPostCode(short postCode) {
        this.postCode = postCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }
    //</editor-fold>
}
