package org.example;

public class User {
    private String username;
    private String password;

    private String firstName;
    private String surname;

    private String streetAddress;
    private String citySuburb;
    private short postCode;

    private long phoneNumber;
    private boolean isAdmin;


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
}
