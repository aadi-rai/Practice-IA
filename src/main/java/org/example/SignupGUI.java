package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupGUI extends JPanel implements CreateUI {
    private final MainFrame mainFrame;
    private final Controller controller;

    public SignupGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        createUI();
    }

    public void createUI() {
        removeAll();

        //<editor-fold desc="UI creation">
        MainFrame.createLabel(this, "Enter your details", 100, 100, 1000, 100, MainFrame.font);

        JTextField usernameField = new JTextField();
        MainFrame.createLabelFieldPair(this, usernameField, "Email/Username:", 100, 225);

        JPasswordField passwordField = new JPasswordField();
        MainFrame.createLabelFieldPair(this, passwordField, "Password:", 600, 225);

        JTextField firstNameField = new JTextField();
        MainFrame.createLabelFieldPair(this, firstNameField, "Firstname:", 100, 350);

        JTextField surnameField = new JTextField();
        MainFrame.createLabelFieldPair(this, surnameField, "Surname:", 600, 350);

        JTextField streetAddressField = new JTextField();
        MainFrame.createLabelFieldPair(this, streetAddressField, "Street Address:", 100, 475);

        JTextField citySuburbField = new JTextField();
        MainFrame.createLabelFieldPair(this, citySuburbField, "City/Suburb:", 600, 475);

        JTextField postcodeField = new JTextField();
        MainFrame.createLabelFieldPair(this, postcodeField, "Postcode:", 100, 600);

        JTextField phoneNumberField = new JTextField();
        MainFrame.createLabelFieldPair(this, phoneNumberField, "Phone Number:", 600, 600);

        MainFrame.createPanel(this, 1098, 0, 4, 900, Color.BLACK);

        MainFrame.createPanel(this, 1250, 50, 200, 200, Color.BLUE);

        JButton signupButton = new JButton("Sign Up");
        MainFrame.setupTextComponent(this, signupButton, 1200, 300, 300, 100, MainFrame.font);

        JCheckBox termsButton = new JCheckBox("<html>I agree to the terms & conditions</html>");
        MainFrame.setupTextComponent(this, termsButton, 1200, 400, 300, 100, MainFrame.secondFont);

        JButton backButton = new JButton("Back");
        MainFrame.setupTextComponent(this, backButton, 1250, 600, 200, 50, MainFrame.secondFont);
        //</editor-fold>

        //<editor-fold desc="Functionality">
        signupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (termsButton.isSelected()) {
                    controller.addUser(new User(usernameField.getText(),
                            passwordField.getText(),
                            firstNameField.getText(),
                            surnameField.getText(),
                            streetAddressField.getText(),
                            citySuburbField.getText(),
                            Short.parseShort(postcodeField.getText()),
                            Long.parseLong(phoneNumberField.getText()),
                            false
                    ));

                    mainFrame.switchPanel(MainFrame.MAIN_GUI);
                }
            }
        });

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.switchPanel(MainFrame.MAIN_GUI);
            }
        });
        //</editor-fold>
    }
}