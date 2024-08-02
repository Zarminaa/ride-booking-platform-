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


public class UserProfile{

    @FXML
    TextField cityP;
    @FXML
    TextField areaP;
    @FXML
    TextField townP;
    @FXML
    TextField streetP;
    @FXML
    TextField houseP;
    @FXML
    TextField cityD;
    @FXML
    TextField areaD;
    @FXML
    TextField townD;
    @FXML
    TextField streetD;
    @FXML
    TextField houseD;
    @FXML
    AnchorPane dropPane;
    @FXML
    AnchorPane pickPane;
    @FXML
    Label wrongEmail;
    @FXML
    TextField transferTf;
    @FXML
    TextField emaillTf;
    @FXML
    Label lessCreditT;
    @FXML
    Label lessCredit;
    @FXML
    TextField withDrawTf;
    @FXML
    TextField addMoneyTf;
    @FXML
    Label totalCredit;
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
    public static Scene UP;
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
        totalCredit.setText(String.valueOf(SessionManager.currentUser.initialBalance));
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookU.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }
    public void bookB(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bookU.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }

    public void rideHistory(ActionEvent event) throws IOException {

        try{
            new BookingHistoryForUser().start(new Stage());

        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void message(ActionEvent event) throws IOException {
            if(!SessionManager.currentUser.booked){
                return;
            }
        try{
            new MessageU().start(new Stage());

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
    public void addM(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {

        double amount = Double.parseDouble(addMoneyTf.getText());
        // Read all users from the file into an ArrayList
        ArrayList<User> users=new ArrayList<User>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
           // users.add((User) ois.readObject());

                while (true) {
                    try {
                        users.add((User) ois.readObject());
                    } catch (EOFException e) {
                        break; // Reached end of file
                    }
                }
        }
        // Find the currently logged-in user and update its initialBalance
        for (User user : users) {

            if (user.email.equals(SessionManager.currentUser.email)) {
                user.initialBalance+=amount;
                SessionManager.currentUser=user;
                break;
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        }
        // Update the displayed total credit
        totalCredit.setText(String.valueOf(SessionManager.currentUser.initialBalance));
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
        if(amount>SessionManager.currentUser.initialBalance){
            lessCredit.setVisible(true);
        }
        else {
            lessCredit.setVisible(false);
            // Read all users from the file into an ArrayList
            ArrayList<User> users = new ArrayList<User>();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
                // users.add((User) ois.readObject());

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

                if (user.email.equals(SessionManager.currentUser.email)) {
                    user.initialBalance -= amount;
                    SessionManager.currentUser = user;
                    break;
                }
            }
            // Write all users back to the file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
                for (User user : users) {
                    oos.writeObject(user);
                }
            }
            // Update the displayed total credit
            totalCredit.setText(String.valueOf(SessionManager.currentUser.initialBalance));
        }
    }
    public void withdrawM() throws IOException {
        double amount = Double.parseDouble(transferTf.getText());
            // Read all users from the file into an ArrayList
            ArrayList<User> users = new ArrayList<User>();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
                // users.add((User) ois.readObject());

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

                if (user.email.equals(SessionManager.currentUser.email)) {
                    user.initialBalance -= amount;
                    SessionManager.currentUser = user;
                    break;
                }
            }
            // Write all users back to the file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
                for (User user : users) {
                    oos.writeObject(user);
                }
            }
            // Update the displayed total credit
            totalCredit.setText(String.valueOf(SessionManager.currentUser.initialBalance));
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
        if(amount>SessionManager.currentUser.initialBalance){
            lessCreditT.setVisible(true);
            return;
        }
        lessCreditT.setVisible(false);
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

            if (driver.email.equals(email)) {
                driver.initialBalance += amount;
                withdrawM();
                break;
            }
            else{
                wrongEmail.setVisible(true);
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
            for (Driver driver : drivers) {
                oos.writeObject(driver);
            }
        }


    }
    public void optionT(MouseEvent mouseEvent) {
        sending.setVisible(false);
    }

    public void pickUp(MouseEvent mouseEvent) throws IOException {
        pickPane.setVisible(true);
    }

    public void dropOff(MouseEvent mouseEvent) {
        dropPane.setVisible(true);
    }
    public void backL(MouseEvent mouseEvent) {
        pickPane.setVisible(false);
    }

    public void backL2(MouseEvent mouseEvent) {
        dropPane.setVisible(false);
    }

    public void savePick(MouseEvent mouseEvent) throws IOException {
        String city=cityP.getText();
        String area=areaP.getText();
        String town=townP.getText();
        String street=streetP.getText();
        String house=houseP.getText();
        Address pickUp=new Address(city,area,town,street,house);
        // Read all users from the file into an ArrayList
        ArrayList<User> users = new ArrayList<User>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
            // users.add((User) ois.readObject());

            while (true) {
                try {
                    users.add((User) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Reached end of file
                }
            }
        }
        // Find the currently logged-in user and update its address
        for (User user : users) {

            if (user.email.equals(SessionManager.currentUser.email)) {
                user.pick=pickUp;
                SessionManager.currentUser = user;
                break;
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        }

    }

    public void saveDrop(MouseEvent mouseEvent) throws IOException {
        String city=cityD.getText();
        String area=areaD.getText();
        String town=townD.getText();
        String street=streetD.getText();
        String house=houseD.getText();
        Address dropOff=new Address(city,area,town,street,house);
        // Read all users from the file into an ArrayList
        ArrayList<User> users = new ArrayList<User>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
            // users.add((User) ois.readObject());

            while (true) {
                try {
                    users.add((User) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Reached end of file
                }
            }
        }
        // Find the currently logged-in user and update its address
        for (User user : users) {

            if (user.email.equals(SessionManager.currentUser.email)) {
                user.drop=dropOff;
                SessionManager.currentUser = user;
                break;
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        }
    }


}
