package com.example.javafxtest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SignD implements Initializable {
    @FXML
    Label noSignUp;
    @FXML
    Label emailExist;
    @FXML
    Label emailInvalid;
    @FXML
    Label passInvalid;
    @FXML
    Label passConfirm;
    @FXML
    Label phoneInvalid;
    @FXML
    Label plateInvalid;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField plateTf;
    @FXML
    RadioButton carP;
    @FXML
    RadioButton carM;
    @FXML
    RadioButton rickshaw;
    @FXML
    RadioButton bike;
    @FXML
    ImageView lamp1;
    @FXML
    ImageView lamp2;
    @FXML
    RadioButton male;
    @FXML
    RadioButton female;
    @FXML
    ImageView carLamp;

    public static Scene signD;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup t=new ToggleGroup();
        // Assign the ToggleGroup to the RadioButtons
        male.setToggleGroup(t);
        female.setToggleGroup(t);
        ToggleGroup t2=new ToggleGroup();
        carP.setToggleGroup(t2);
        carM.setToggleGroup(t2);
        rickshaw.setToggleGroup(t2);
        bike.setToggleGroup(t2);
    }

    public void turnOn(MouseEvent mouseEvent) {
        carLamp.setVisible(true);
    }

    public void turnOff(MouseEvent mouseEvent) {
        carLamp.setVisible(false);
    }

    public void goBack(MouseEvent mouseEvent) {
        HelloApplication.stage1.setScene(Controller1.DLpage);
        HelloApplication.stage1.show();
    }

    public void lampOn(MouseEvent mouseEvent) {
        if (lamp1.isVisible() && lamp2.isVisible()) {
            lamp1.setVisible(false);
            lamp2.setVisible(false);
        } else if (!lamp1.isVisible() && !lamp2.isVisible()) {
            lamp1.setVisible(true);
            lamp2.setVisible(true);
        }
    }

    public void up(MouseEvent mouseEvent) throws IOException {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String phone = phoneField.getText();
        String plateNo=plateTf.getText();
        String gender = male.isSelected() ? "Male" : "Female";
        String carType="No";
        if (carP.isSelected()){
            carType="premium";
        }
        else if(carM.isSelected()){
            carType="car-mini";
        }
        else if(rickshaw.isSelected()){
            carType="rickshaw";
        }
        else if(bike.isSelected()){
            carType="bike";
        }

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty() || plateNo.isEmpty()) {
            noSignUp.setVisible(true);
            return;
        } else {
            noSignUp.setVisible(false);
        }
        // Validate password confirmation
        if (!password.equals(confirmPassword)) {
            passConfirm.setVisible(true);
            return;
        } else {
            passConfirm.setVisible(false);
        }

        // Validate phone format
        if (!phone.matches("^\\+92\\d{10}$")) {
            phoneInvalid.setVisible(true);
            return;
        } else {
            phoneInvalid.setVisible(false);
        }

        // Validate password length
        String passwordRegex = ".{8,}";
        if (!password.matches(passwordRegex)) {
            passInvalid.setVisible(true);
            return;
        } else {
            passInvalid.setVisible(false);
        }
        //Validate plateNo Format;
        String plateRegix="^[A-Z]{3}[0-9]{3}$"; // Three letters followed by three numbers
        if(!plateNo.matches(plateRegix)){
            plateInvalid.setVisible(true);
            return;
        }
        else {
            plateInvalid.setVisible(false);
        }

        // Validate email format
        if (!email.matches("^[a-zA-Z0-9._%+-]+@email\\.com$")) {
            emailInvalid.setVisible(true);
            return;
        } else {
            emailInvalid.setVisible(false);
        }

        // Check if email already exists
        File emailFile = new File("EmailD.txt");
        boolean emailExists = false;
        if (emailFile.exists()) {
            try (Scanner reader = new Scanner(emailFile)) {
                while (reader.hasNextLine()) {
                    String existingEmail = reader.nextLine();
                    if (existingEmail.equals(email)) {
                        emailExists = true;
                        break;
                    }
                }
            }
        }

        if (emailExists) {
            emailExist.setVisible(true);
            return;
        } else {
            emailExist.setVisible(false);
            // Append email to Email.txt if it doesn't already exist
            try (FileWriter fw = new FileWriter("EmailD.txt", true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println(email);
            }
        }

        Driver newDriver= new Driver(username,email,password,confirmPassword,phone,gender,plateNo,carType,null);
        SessionManager.currentDriver=newDriver;
        noSignUp.setVisible(false);
        // Append new user to UserRepository.txt using ObjectOutputStream
        File driverFile = new File("DriverRepository.txt");
        ArrayList<Driver> drivers = new ArrayList<>();

        if(driverFile.exists()&&driverFile.length()>0){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(driverFile))){
                while (true) {
                    try {
                        Driver driver = (Driver) ois.readObject();
                        drivers.add(driver);
                    } catch (EOFException e) {
                        break;
                    }
                }
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    drivers.add(newDriver);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(driverFile))){
            for (Driver d:drivers){
                oos.writeObject(d);
            }
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DriverProfile.fxml"));
        Scene scene=new Scene(loader.load());
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();

    }
}
