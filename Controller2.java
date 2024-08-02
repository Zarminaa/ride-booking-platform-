package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;


public class Controller2 {
    @FXML
    Label recheck;
    @FXML
    TextField emailTf;
    @FXML
    TextField passTf;
    @FXML
    ImageView carLamp;
    @FXML
    AnchorPane lStage;

    public void goBack(MouseEvent mouseEvent) {
      HelloApplication.stage1.setScene(HelloApplication.scene1);
      HelloApplication.stage1.show();
    }

    public void logged(ActionEvent event) throws IOException {
        String email = emailTf.getText().trim();
        String password = passTf.getText().trim();
        File file = new File("UserRepository.txt");

        if (file.length() == 0) {
            recheck.setVisible(true);
            return;
        }


        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                try {
                    User user = (User) reader.readObject();
                    if (user.email.equals(email) && user.password.equals(password)) {
                        System.out.println(user);
                        SessionManager.currentUser=user;
                        recheck.setVisible(false);
                        // Open UserProfile
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UserProfile.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        UserProfile.UP=scene;
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signU.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }

    public void turnOff(MouseEvent mouseEvent) {
        carLamp.setVisible(false);
    }

    public void turnOn(MouseEvent mouseEvent) {
        carLamp.setVisible(true);
    }

}
