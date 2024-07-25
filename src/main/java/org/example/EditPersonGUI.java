package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPersonGUI extends JPanel implements CreateUI {
    private final MainFrame mainFrame;
    private final Controller controller;

    public EditPersonGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        createUI();
    }

    public void createUI() {
        removeAll();
        User currentUser = controller.getCurrentUser();

        if (currentUser != null) {

            //<editor-fold desc="UI Creation">
            MainFrame.createLabel(this, "Update your details", 100, 100, 1000, 100, MainFrame.font);

            JTextField usernameField = new JTextField(currentUser.getUsername());
            MainFrame.createLabelFieldPair(this, usernameField, "Email/Username:", 100, 225);

            JPasswordField passwordField = new JPasswordField(currentUser.getPassword());
            MainFrame.createLabelFieldPair(this, passwordField, "Password:", 600, 225);

            JTextField firstNameField = new JTextField(currentUser.getFirstName());
            MainFrame.createLabelFieldPair(this, firstNameField, "Firstname:", 100, 350);

            JTextField surnameField = new JTextField(currentUser.getSurname());
            MainFrame.createLabelFieldPair(this, surnameField, "Surname:", 600, 350);

            JTextField streetAddressField = new JTextField(currentUser.getStreetAddress());
            MainFrame.createLabelFieldPair(this, streetAddressField, "Street Address:", 100, 475);

            JTextField citySuburbField = new JTextField(currentUser.getCitySuburb());
            MainFrame.createLabelFieldPair(this, citySuburbField, "City/Suburb:", 600, 475);

            JTextField postcodeField = new JTextField(String.valueOf(currentUser.getPostCode()));
            MainFrame.createLabelFieldPair(this, postcodeField, "Postcode:", 100, 600);

            JTextField phoneNumberField = new JTextField(String.valueOf(currentUser.getPhoneNumber()));
            MainFrame.createLabelFieldPair(this, phoneNumberField, "Phone Number:", 600, 600);

            MainFrame.createPanel(this, 1098, 0, 4, 900, Color.BLACK);

            MainFrame.createPanel(this, 1200, 100, 300, 300, Color.BLUE);

            JButton updateButton = new JButton("Update");
            MainFrame.setupTextComponent(this, updateButton, 1200, 600, 300, 100, MainFrame.font);

            JCheckBox adminButton = new JCheckBox("Make user admin");

            MainFrame.setupTextComponent(this, adminButton, 1200, 400, 300, 100, MainFrame.secondFont);
            if (!currentUser.isAdmin()) {
                adminButton.setVisible(false);
            } else {
                adminButton.setSelected(true);
            }
            //</editor-fold>

            //<editor-fold desc="Functionality">
            updateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentUser.setUsername(usernameField.getText());
                    currentUser.setPassword(passwordField.getText());
                    currentUser.setFirstName(firstNameField.getText());
                    currentUser.setSurname(surnameField.getText());
                    currentUser.setStreetAddress(streetAddressField.getText());
                    currentUser.setCitySuburb(citySuburbField.getText());
                    currentUser.setPostCode(Short.parseShort(postcodeField.getText()));
                    currentUser.setPhoneNumber(Long.parseLong(phoneNumberField.getText()));
                    currentUser.setAdmin(adminButton.isSelected());

                    if (currentUser.isAdmin()) {
                        mainFrame.switchPanel(MainFrame.ADMIN_GUI);
                    } else {
                        mainFrame.switchPanel(MainFrame.USER_GUI);
                    }
                }
            });
            //</editor-fold>
        }
    }
}