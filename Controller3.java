package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class Controller3 {
    @FXML
    TextField emailTf;
    @FXML
    TextField passTf;
    @FXML
    Label recheck;
    @FXML
    ImageView carLamp;

    public void turnOn(MouseEvent mouseEvent) {
    carLamp.setVisible(true);
    }

    public void turnOff(MouseEvent mouseEvent) {
    carLamp.setVisible(false);
    }
    public void goBack(MouseEvent mouseEvent) {
        HelloApplication.stage1.setScene(HelloApplication.scene1);
        HelloApplication.stage1.show();
    }
    public void logged(ActionEvent event) throws IOException {
        String email = emailTf.getText();
        String password = passTf.getText();
        File file = new File("DriverRepository.txt");
        if (file.length() == 0) {
            recheck.setVisible(true);
            return;
        }

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                   Driver driver = (Driver) reader.readObject();
                    if (driver.email.equals(email) && driver.password.equals(password)) {
                        System.out.println(driver);
                        SessionManager.currentDriver=driver;
                        recheck.setVisible(false);
                        // Open UserProfile
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DriverProfile.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        DriverProfile.DP=scene;
                        HelloApplication.stage1.setScene(scene);
                        HelloApplication.stage1.show();
                        return; // Exit the method after opening UserProfile
                    }
                } catch (EOFException e) {
                    break; // Reached end of file
                } catch (ClassNotFoundException e) {
                    e.printStackTrace(); // Handle class not found exception
                }
            }
        }

        // If email or password doesn't match, set the visibility of a label to true
        recheck.setVisible(true);
    }

    public void up(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signD.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        SignD.signD=scene;
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }

}
