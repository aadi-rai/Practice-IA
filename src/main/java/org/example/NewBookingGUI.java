package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class NewBookingGUI extends JPanel implements CreateUI {
    private final MainFrame mainFrame;
    private final Controller controller;

    public NewBookingGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        createUI();
    }

    public void createUI() {
        removeAll();
        User currentUser = controller.getCurrentUser();

        //<editor-fold desc="UI Creation">
        MainFrame.createLabel(this, "New Booking", 100, 100, 1000, 100, MainFrame.font);

        MainFrame.createLabel(this, "Payment Info", 1200, 100, 1000, 100, MainFrame.secondFont);

        MainFrame.createPanel(this, 1098, 0, 4, 900, Color.BLACK);

        JTextField cardNumberField = new JTextField();
        MainFrame.createLabelFieldPair(this, cardNumberField, "Card Number:", 1200, 225);
        // manually override field size
        cardNumberField.setSize(300, 50);

        JTextField expiryField = new JTextField();
        MainFrame.createLabelFieldPair(this, expiryField, "Exp Date:", 1200, 350);
        expiryField.setSize(100, 50);

        JTextField CVCField = new JTextField();
        MainFrame.createLabelFieldPair(this, CVCField, "CVC:", 1400, 350);
        CVCField.setSize(100, 50);

        JButton bookNowButton = new JButton("Book Now");
        MainFrame.setupTextComponent(this, bookNowButton, 1200, 475, 300, 100, MainFrame.secondFont);

        MainFrame.createLabel(this, "", 600, 225, 400, 300, MainFrame.secondFont);

        ArrayList<Event> events = controller.getEvents();

        ArrayList<Event> availableEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.isAvailable()) {
                availableEvents.add(event);
            }
        }
        String[] eventDates = new String[availableEvents.size()];
        for (int i = 0; i < availableEvents.size(); i++) {
            eventDates[i] = MainFrame.formatter.format(availableEvents.get(i).getDate());
        }

        JComboBox eventPicker = new JComboBox(eventDates);
        MainFrame.setupTextComponent(this, eventPicker, 100, 225, 300, 50, MainFrame.secondFont);

        JLabel eventInformation = new JLabel("test");
        MainFrame.setupTextComponent(this, eventInformation, 450, 225, 300, 300, MainFrame.secondFont);
        //</editor-fold>

        eventPicker.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                eventInformation.setText(controller.findEventByDateString((String)eventPicker.getSelectedItem()).getEventID());
            }
        });




    }
}