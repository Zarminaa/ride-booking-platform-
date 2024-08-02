package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class DriverProfile {

    @FXML
    TextField areaTf;
    @FXML
    Label wrongEmail;
    @FXML
    TextField transferTf;
    @FXML
    Label lessCreditT;
    @FXML
    TextField emaillTf;
    @FXML
    Label lessCredit;
    @FXML
    Label totalCredit;
    @FXML
    TextField withDrawTf;
    @FXML
    TextField addMoneyTf;
    @FXML
    Button B;
    @FXML
    Button rh;
    @FXML
    Button M;
    @FXML
    Button L;
    @FXML
    AnchorPane adding;
    @FXML
    AnchorPane taking;
    @FXML
    AnchorPane sending;
    public static Scene DP;
    // Save the original styles
    private String originalBStyle;
    private String originalRhStyle;
    private String originalMStyle;
    private String originalLStyle;

    public void initialize() {

        // Save the original styles when the controller is initialized
        originalBStyle = B.getStyle();
        originalRhStyle = rh.getStyle();
        originalMStyle = M.getStyle();
        originalLStyle = L.getStyle();
        totalCredit.setText(String.valueOf(SessionManager.currentDriver.initialBalance));
    }

    public void colorB(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
            B.setStyle("-fx-background-color: black; -fx-background-radius: 24;");
        }
    }

    public void colourR(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
            rh.setStyle("-fx-background-color: black; -fx-background-radius: 24;");
        }
    }

    public void colorM(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
            M.setStyle("-fx-background-color: black; -fx-background-radius: 24;");
        }
    }

    public void colorL(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
            L.setStyle("-fx-background-color: black; -fx-background-radius: 24;");
        }
    }
    public void book(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookD.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }

    public void rideHistory(ActionEvent event) throws IOException {
        try{
            new BookingHistoryForDriver().start(new Stage());

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void message(ActionEvent event) throws IOException {
            if(!SessionManager.currentDriver.booked){
                return;
            }
        try{
        new MessageDriver().start(new Stage());

    }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void oB(MouseEvent mouseEvent) {
        B.setStyle(originalBStyle);
    }

    public void oR(MouseEvent mouseEvent) {
        rh.setStyle(originalRhStyle);
    }

    public void oM(MouseEvent mouseEvent) {
        M.setStyle(originalMStyle);
    }
    public void oL(MouseEvent mouseEvent){
        L.setStyle(originalLStyle);
    }

    public void shut(ActionEvent event) {
        HelloApplication.stage1.setScene(HelloApplication.scene1);
        HelloApplication.stage1.show();
    }
    public void shutL(MouseEvent mouseEvent) {
        HelloApplication.stage1.setScene(HelloApplication.scene1);
        HelloApplication.stage1.show();
    }
    //adding
    public void add(MouseEvent mouseEvent) {
        adding.setVisible(true);
    }
    public void addM(MouseEvent mouseEvent) throws IOException {
        double amount = Double.parseDouble(addMoneyTf.getText());
        // Read all users from the file into an ArrayList
        ArrayList<Driver> drivers=new ArrayList<Driver>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverRepository.txt"))) {

            while (true) {
                try {
                    drivers.add((Driver) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Reached end of file
                }
            }
        }
        // Find the currently logged-in user and update its initialBalance
        for (Driver driver : drivers) {

            if (driver.email.equals(SessionManager.currentDriver.email)) {
                driver.initialBalance+=amount;
                SessionManager.currentDriver=driver;
                break;
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
            for (Driver driver : drivers) {
                oos.writeObject(driver);
            }
        }
        // Update the displayed total credit
        totalCredit.setText(String.valueOf(SessionManager.currentDriver.initialBalance));
    }

    public void optionM(MouseEvent mouseEvent) {
        adding.setVisible(false);
    }
    //withdraw
    public void withdraw(MouseEvent mouseEvent) {
        taking.setVisible(true);
    }
    public void withdrawM(MouseEvent mouseEvent) throws IOException {

        double amount = Double.parseDouble(withDrawTf.getText());
        if(amount>SessionManager.currentDriver.initialBalance){
            lessCredit.setVisible(true);
        }
        else {
            lessCredit.setVisible(false);
            // Read all users from the file into an ArrayList
            ArrayList<Driver> drivers = new ArrayList<Driver>();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverRepository.txt"))) {

                while (true) {
                    try {
                        drivers.add((Driver) ois.readObject());
                    } catch (IOException | ClassNotFoundException e) {
                        break; // Reached end of file
                    }
                }
            }
            // Find the currently logged-in user and update its initialBalance
            for (Driver driver : drivers) {

                if (driver.email.equals(SessionManager.currentDriver.email)) {
                    driver.initialBalance -= amount;
                    SessionManager.currentDriver = driver;
                    break;
                }
            }
            // Write all users back to the file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
                for (Driver driver : drivers) {
                    oos.writeObject(driver);
                }
            }
            // Update the displayed total credit
            totalCredit.setText(String.valueOf(SessionManager.currentDriver.initialBalance));
        }
    }
    public void withdrawM() throws IOException {

        double amount = Double.parseDouble(transferTf.getText());
            lessCredit.setVisible(false);
            // Read all users from the file into an ArrayList
            ArrayList<Driver> drivers = new ArrayList<Driver>();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverRepository.txt"))) {

                while (true) {
                    try {
                        drivers.add((Driver) ois.readObject());
                    } catch (IOException | ClassNotFoundException e) {
                        break; // Reached end of file
                    }
                }
            }
            // Find the currently logged-in user and update its initialBalance
            for (Driver driver : drivers) {

                if (driver.email.equals(SessionManager.currentDriver.email)) {
                    driver.initialBalance -= amount;
                    SessionManager.currentDriver = driver;
                    break;
                }
            }
            // Write all users back to the file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
                for (Driver driver : drivers) {
                    oos.writeObject(driver);
                }
            }
            // Update the displayed total credit
            totalCredit.setText(String.valueOf(SessionManager.currentDriver.initialBalance));
    }

    public void optionW(MouseEvent mouseEvent) {;
        taking.setVisible(false);
    }
    //transfer
    public void transfer(MouseEvent mouseEvent) {
        sending.setVisible(true);
    }
    public void transferM(MouseEvent mouseEvent) throws IOException {
        String email=emaillTf.getText();

        double amount=Double.parseDouble(transferTf.getText());
        if(amount>SessionManager.currentDriver.initialBalance){
            lessCreditT.setVisible(true);
            return;
        }
        lessCreditT.setVisible(false);
        // Read all users from the file into an ArrayList
        ArrayList<User> users = new ArrayList<User>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {

            while (true) {
                try {
                    users.add((User) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Reached end of file
                }
            }
        }
        // Find the currently logged-in user and update its initialBalance
        for (User user : users) {

            if (user.email.equals(email)) {
                user.initialBalance += amount;
                withdrawM();
                break;
            }
            else{
                wrongEmail.setVisible(true);
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        }
    }
    public void optionT(MouseEvent mouseEvent) {
        sending.setVisible(false);
    }

    public void addArea(MouseEvent mouseEvent) throws IOException {
        String Area=areaTf.getText();
        // Read all users from the file into an ArrayList
        ArrayList<Driver> drivers=new ArrayList<Driver>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverRepository.txt"))) {

            while (true) {
                try {
                    drivers.add((Driver) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Reached end of file
                }
            }
        }
        // Find the currently logged-in user and update its initialBalance
        for (Driver driver : drivers) {

            if (driver.email.equals(SessionManager.currentDriver.email)) {
                driver.area=Area;
                SessionManager.currentDriver=driver;
                break;
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
            for (Driver driver : drivers) {
                oos.writeObject(driver);
            }
        }

    }

}
