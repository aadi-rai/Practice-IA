package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JPanel {
    private final MainFrame mainFrame;
    private final Controller controller;

    public LoginGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        //<editor-fold desc="UI Creation">
        MainFrame.createPanel(this, 200, 100, 600, 600, Color.BLUE);

        MainFrame.createLabel(this, "Disaster Area Event Booking", 100, 750, 800, 80, MainFrame.font);

        MainFrame.createPanel(this, 998, 0, 4, 900, Color.BLACK);

        JTextField usernameField = new JTextField();
        MainFrame.createLabelFieldPair(this, usernameField, "Username:", 1100, 175);

        JPasswordField passwordField = new JPasswordField();
        MainFrame.createLabelFieldPair(this, passwordField, "Password:", 1100, 375);

        JLabel invalidLabel = new JLabel("Invalid Login");
        MainFrame.setupTextComponent(this, invalidLabel, 1100, 725, 400, 50, MainFrame.secondFont);
        invalidLabel.setForeground(Color.RED); invalidLabel.setVisible(false);

        JButton confirmButton = new JButton("Log In");;
        MainFrame.setupTextComponent(this, confirmButton, 1100, 600, 400, 100, MainFrame.font);
        //</editor-fold>

        //<editor-fold desc="Functionality">
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (controller.login(usernameField.getText(), passwordField.getText())) {
                    mainFrame.switchPanel(MainFrame.USER_GUI);
                } else {
                    invalidLabel.setVisible(true);
                }
            }
        });
        //</editor-fold>
    }
}