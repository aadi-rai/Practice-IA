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

        Font font = new Font("Serif", Font.PLAIN, 54);
        Font secondFont = new Font("Serif", Font.PLAIN, 30);

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.BLUE); logoPanel.setOpaque(true);
        logoPanel.setLocation(200, 100);
        logoPanel.setSize(new Dimension(600, 600));
        add(logoPanel);

        JLabel companyNameLabel = new JLabel("Disaster Area Event Booking");
        companyNameLabel.setFont(font);
        companyNameLabel.setLocation(100, 750);
        companyNameLabel.setSize(new Dimension(800, 80));
        add(companyNameLabel);

        JPanel separatorPanel = new JPanel();
        separatorPanel.setBackground(Color.BLACK); separatorPanel.setOpaque(true);
        separatorPanel.setLocation(998, 0);
        separatorPanel.setSize(new Dimension(4, 900));
        add(separatorPanel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setLocation(1100, 175);
        usernameLabel.setSize(new Dimension(200, 25));
        usernameLabel.setFont(secondFont);
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setLocation(1100, 200);
        usernameField.setSize(new Dimension(400, 50));
        usernameField.setFont(secondFont);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setLocation(1100, 350);
        passwordLabel.setSize(new Dimension(200, 25));
        passwordLabel.setFont(secondFont);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setLocation(1100, 375);
        passwordField.setSize(new Dimension(400, 50));
        passwordField.setFont(secondFont);
        add(passwordField);

        JLabel invalidLabel = new JLabel("Invalid Login");
        invalidLabel.setFont(secondFont);
        invalidLabel.setForeground(Color.RED);
        invalidLabel.setLocation(1100, 725);
        invalidLabel.setSize(new Dimension(400, 50));
        invalidLabel.setVisible(false);
        add(invalidLabel);

        JButton confirmButton = new JButton("Log In");;
        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (controller.login(usernameField.getText(), passwordField.getText())) {
                    mainFrame.switchPanel(MainFrame.USER_GUI);
                } else {
                    invalidLabel.setVisible(true);
                }
            }
        });
        confirmButton.setFont(font);
        confirmButton.setLocation(1100, 600);
        confirmButton.setSize(new Dimension(400, 100));
        add(confirmButton);
    }
}