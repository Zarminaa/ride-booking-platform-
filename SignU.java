

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

public class SignU implements Initializable {
    @FXML
    private Label noSignUp;
    @FXML
    private Label passInvalid;
    @FXML
    private Label phoneInvalid;
    @FXML
    private Label passConfirm;
    @FXML
    private Label emailExist;
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
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private Label emailInvalid;
    @FXML
    ImageView lamp1;
    @FXML
    ImageView lamp2;
    @FXML
    ImageView carLamp;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup t=new ToggleGroup();
      // Assign the ToggleGroup to the RadioButtons
        male.setToggleGroup(t);
        female.setToggleGroup(t);
    }

    public void turnOn(MouseEvent mouseEvent) {
        carLamp.setVisible(true);
    }

    public void turnOff(MouseEvent mouseEvent) {
        carLamp.setVisible(false);
    }

    public void goBack(MouseEvent mouseEvent) {
        HelloApplication.stage1.setScene(Controller1.ULpage);
        HelloApplication.stage1.show();
    }
    public void up(MouseEvent mouseEvent) throws IOException {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String phone = phoneField.getText();
        String gender = male.isSelected() ? "Male" : "Female";

        // Check if any field is empty
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty()) {
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

        // Validate email format
        if (!email.matches("^[a-zA-Z0-9._%+-]+@email\\.com$")) {
            emailInvalid.setVisible(true);
            return;
        } else {
            emailInvalid.setVisible(false);
        }
        // Check if email already exists
        File emailFile = new File("Email.txt");
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
            try (FileWriter fw = new FileWriter("Email.txt", true); PrintWriter pw = new PrintWriter(fw)) {
                pw.println(email);
            }
        }

        // If all validations pass, create User object
        User newUser = new User(username,email,password,confirmPassword,phone,gender,  null,null,null,null);
        SessionManager.currentUser=newUser;
        noSignUp.setVisible(false);

        // Append new user to UserRepository.txt using ObjectOutputStream
        File userFile = new File("UserRepository.txt");
        ArrayList<User> users = new ArrayList<>();

        // Read existing users
        if (userFile.exists() && userFile.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userFile))) {
                while (true) {
                    try {
                        User user = (User) ois.readObject();
                        users.add(user);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Add the new user to the list
        users.add(SessionManager.currentUser);

        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userFile))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        }
       // SessionManager.user=users;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserProfile.fxml"));
        Scene scene=new Scene(loader.load());
        HelloApplication.stage1.setScene(scene);
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
}

