package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JPanel {
    private final MainFrame mainFrame;
    private final Controller controller;

    public MainGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        Font font = new Font("Serif", Font.PLAIN, 54);

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

        JButton loginButton = new JButton("Log In");;
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.switchPanel(MainFrame.LOGIN_GUI);
            }
        });
        loginButton.setFont(font);
        loginButton.setLocation(1100, 200);
        loginButton.setSize(new Dimension(400, 200));
        add(loginButton);

        JButton signupButton = new JButton("Sign Up");;
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.switchPanel(MainFrame.SIGNUP_GUI);
            }
        });
        signupButton.setFont(font);
        signupButton.setLocation(1100, 500);
        signupButton.setSize(new Dimension(400, 200));
        add(signupButton);
    }
}
