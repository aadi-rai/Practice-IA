package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JPanel implements CreateUI {
    private final MainFrame mainFrame;
    private final Controller controller;

    public MainGUI(MainFrame mainFrame, Controller controller) {
        super(null);

        this.mainFrame = mainFrame;
        this.controller = controller;

        createUI();
    }

    public void createUI() {
        removeAll();

        //<editor-fold desc="UI Creation">
        MainFrame.createPanel(this, 200, 100, 600, 600, Color.BLUE);

        MainFrame.createLabel(this, "Disaster Area Event Booking", 100, 750, 800, 80, MainFrame.font);

        MainFrame.createPanel(this, 998, 0, 4, 900, Color.BLACK);

        JButton loginButton = new JButton("Log In");;
        MainFrame.setupTextComponent(this, loginButton, 1100, 200, 400, 200, MainFrame.font);

        JButton signupButton = new JButton("Sign Up");;
        MainFrame.setupTextComponent(this, signupButton, 1100, 500, 400, 200, MainFrame.font);
        //</editor-fold>

        //<editor-fold desc="Functionality">
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.switchPanel(MainFrame.LOGIN_GUI);
            }
        });

        signupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.switchPanel(MainFrame.SIGNUP_GUI);
            }
        });
        //</editor-fold>
    }
}
