package org.example;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        // create main JFrame on the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = null;
            try {
                mainFrame = new MainFrame();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            mainFrame.setSize(1650, 950);
            mainFrame.setResizable(false);

            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
        });
    }
}