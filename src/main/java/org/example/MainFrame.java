package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class MainFrame extends JFrame {
    private final JPanel mainPanel;
    private final CardLayout cardLayout;
    Controller controller;

    final static String MAIN_GUI   = "1";
    final static String LOGIN_GUI  = "2";
    final static String SIGNUP_GUI = "3";
    final static String USER_GUI   = "4";
    final static String ADMIN_GUI  = "5";
    final static String EDIT_PERSON_GUI  = "6";
    final static String EDIT_BOOKING_GUI = "7";
    final static String EDIT_EVENT_GUI   = "8";
    final static String NEW_BOOKING_GUI  = "9";

    final static Font font = new Font("Serif", Font.PLAIN, 54);
    final static Font secondFont = new Font("Serif", Font.PLAIN, 30);

    private final HashMap<String, CreateUI> panels;

    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

    public MainFrame() throws IOException, ClassNotFoundException {
        super("Disaster Area");

        // create or deserialize controller
        File f = new File("./controller");
        if (f.exists() && !f.isDirectory()) {
            controller = (Controller)SerializationManager.read("./controller");
        } else {
            controller = new Controller();
        }

        // create listener to serialize controller on program close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    SerializationManager.write(controller, "./controller");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        panels = new HashMap<>();

        JPanel mainGUI = new MainGUI(this, controller);
        panels.put(MAIN_GUI, (CreateUI) mainGUI);
        mainPanel.add(mainGUI, MAIN_GUI);

        JPanel loginGUI = new LoginGUI(this, controller);
        panels.put(LOGIN_GUI, (CreateUI) loginGUI);
        mainPanel.add(loginGUI, LOGIN_GUI);

        JPanel signupGUI = new SignupGUI(this, controller);
        panels.put(SIGNUP_GUI, (CreateUI) signupGUI);
        mainPanel.add(signupGUI, SIGNUP_GUI);

        JPanel userGUI = new UserGUI(this, controller);
        panels.put(USER_GUI, (CreateUI) userGUI);
        mainPanel.add(userGUI, USER_GUI);

        JPanel editPersonGUI = new EditPersonGUI(this, controller);
        panels.put(EDIT_PERSON_GUI, (CreateUI) editPersonGUI);
        mainPanel.add(editPersonGUI, EDIT_PERSON_GUI);

        JPanel newBookingGUI = new NewBookingGUI(this, controller);
        panels.put(NEW_BOOKING_GUI, (CreateUI) newBookingGUI);
        mainPanel.add(newBookingGUI, NEW_BOOKING_GUI);

        cardLayout.show(mainPanel, MAIN_GUI);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        //controller.addEvent(new Event("abcd", LocalDate.of(2008, 1, 28), "somehwere", 10, 100, true));
        //controller.addEvent(new Event("defg", LocalDate.of(2028, 7, 7), "elsewhere", 20, 50, true));


        pack();
    }

    public void switchPanel(String panelName) {
        panels.get(panelName).createUI();
        cardLayout.show(mainPanel, panelName);
    }

    public static void createPanel(JPanel panel, int x, int y, int w, int h, Color color) {
        JPanel newPanel = new JPanel();
        newPanel.setBackground(color);
        newPanel.setOpaque(true);
        newPanel.setLocation(x, y);
        newPanel.setSize(w, h);
        panel.add(newPanel);
    }

    public static void createLabel(JPanel panel, String text, int x, int y, int w, int h, Font f) {
        JLabel newLabel = new JLabel(text);
        setupTextComponent(panel, newLabel, x, y, w, h, f);
    }

    public static void createLabelFieldPair(JPanel panel, JTextField field, String label, int x, int y) {
        createLabel(panel, label, x, y, 400, 25, secondFont);

        field.setFont(secondFont);
        field.setLocation(x, y+25);
        field.setSize(new Dimension(400, 50));
        panel.add(field);
    }

    public static void setupTextComponent(JPanel panel, JComponent component, int x, int y, int w, int h, Font f) {
        component.setFont(f);
        component.setLocation(x, y);
        component.setSize(w, h);
        panel.add(component);
    }


}
