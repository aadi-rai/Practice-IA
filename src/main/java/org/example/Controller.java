package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller implements Serializable {
    private final ArrayList<User> users;
    private final ArrayList<Booking> bookings;
    private final ArrayList<Event> events;

    private User currentUser;


    public Controller() {
        events = new ArrayList<Event>();
        bookings =  new ArrayList<Booking>();
        users =  new ArrayList<User>();
    }

    public boolean validateUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    //<editor-fold desc="getters/setters">
    public ArrayList<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }

    public Event findEvent(String eventID) {
        for (Event event : events) {
            if (event.getEventID().equals(eventID)) {
                return event;
            }
        }
        return null;
    }

    public Event findEventByDateString(String date) {
        for (Event event : events) {
            if (MainFrame.formatter.format(event.getDate()).equals(date)) {
                return event;
            }
        }
        return null;
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

    public Booking findBooking(String bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                return booking;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    //</editor-fold>
}
