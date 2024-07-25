package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JPanel implements CreateUI {
    private final MainFrame mainFrame;
    private final Controller controller;

    public UserGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        createUI();
    }

    public void createUI()      {
        removeAll();

        //<editor-fold desc="UI Creation">
        MainFrame.createLabel(this, "Current Bookings", 200, 200, 1000, 100, MainFrame.secondFont);

        JButton logoutButton = new JButton("Log Out");
        MainFrame.setupTextComponent(this, logoutButton, 1250, 650, 200, 50, MainFrame.secondFont);

        MainFrame.createPanel(this, 1098, 0, 4, 900, Color.BLACK);

        MainFrame.createPanel(this, 1200, 300, 300, 300, Color.BLUE);

        JButton editProfileButton = new JButton("<html>Edit <br/>Profile</html>");
        MainFrame.setupTextComponent(this, editProfileButton, 800, 75, 200, 100, MainFrame.secondFont);

        JButton newBookingButton = new JButton("<html>New <br/>Booking</html>");
        MainFrame.setupTextComponent(this, newBookingButton, 100, 650, 200, 100, MainFrame.secondFont);

        JButton editBookingButton = new JButton("<html>Edit <br/>Booking</html>");
        MainFrame.setupTextComponent(this, editBookingButton, 450, 650, 200, 100, MainFrame.secondFont);

        JButton cancelBookingButton = new JButton("<html>Cancel <br/>Booking</html>");
        MainFrame.setupTextComponent(this, cancelBookingButton, 800, 650, 200, 100, MainFrame.secondFont);

        if (controller.getCurrentUser() != null) {
            MainFrame.createLabel(this, "Welcome, " + controller.getCurrentUser().getFirstName(), 100, 100, 1000, 100, MainFrame.font);

            //<editor-fold desc="Table Creation">
            String html = "<html><body><table border = '1'>";
            String[] columnNames = {"Date", "Location", "# Tickets", "Ref #"};
            html += "<tr>";
            for (String name : columnNames) {
                html += "<td>" + name + "</td>";
            }
            html += "</tr>";

            for (Booking booking : controller.getCurrentUser().getBookings()) {
                html += "<tr>";
                html += "<td>" + booking.getEvent().getDate() + "</td>";
                html += "<td>" + booking.getEvent().getLocation() + "</td>";
                html += "<td>" + booking.getNumTickets() + "</td>";
                html += "<td>" + booking.getBookingID() + "</td>";
                html += "</tr>";
            }
            html += "</table></body></html>";

            JLabel bookingsTable = new JLabel(html);
            bookingsTable.setVerticalAlignment(JLabel.TOP);
            MainFrame.setupTextComponent(this, bookingsTable, 200, 275, 1000, 300, MainFrame.secondFont);
            //</editor-fold>
        }
        //</editor-fold>

        //<editor-fold desc="Functionality">
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setCurrentUser(null);
                mainFrame.switchPanel(MainFrame.MAIN_GUI);
            }
        });

        editProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchPanel(MainFrame.EDIT_PERSON_GUI);
            }
        });

        newBookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchPanel(MainFrame.NEW_BOOKING_GUI);
            }
        });
        //</editor-fold>
    }
}

