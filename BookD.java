package com.example.javafxtest;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;

public class BookD {
    @FXML
    Label noArea;
    @FXML
    AnchorPane cancelBookPane;
    @FXML
    Label noBook; //this here
    @FXML
    AnchorPane confirmBookPane;
    @FXML
    VBox requestPane;
    @FXML
    AnchorPane searchR;
    @FXML
    ImageView driver;
    @FXML
    ImageView driveT;


        public void initialize(){
           if(SessionManager.currentDriver.booked){
               confirmBookPane.setVisible(true);
           }
           if (SessionManager.currentDriver.cancelled){
               cancelBookPane.setVisible(true);
           }
        }
    public void drive(MouseEvent mouseEvent) {
        driver.setVisible(false);
        driveT.setVisible(true);
        TranslateTransition t=new TranslateTransition(Duration.millis(2500),driveT);
        t.setByX(670);
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }
    public void searchRider(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(SessionManager.currentDriver.area==null){
            noArea.setVisible(true);
            return;
        }
            searchR.setVisible(true);
            noArea.setVisible(false);
        ArrayList<User> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
            System.out.println(SessionManager.currentDriver);
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    System.out.println("Read user: " + user);

                    System.out.println("---------------------------");

                    // Check if the current area of user matches the area of driver
                    if (SessionManager.currentDriver.area.equalsIgnoreCase(user.pick.area.trim())
                            && SessionManager.currentDriver.vehicletype.equalsIgnoreCase(user.vehicleType.trim())
                            && Boolean.TRUE.equals(user.book)) {
                        System.out.println(user);
                        users.add(user);
                    }
                } catch (EOFException e) {
                    break; // Reached end of file
                }
            }
        }

        if (users.size() == 0) {
            System.out.println("No matching users found.");
            return;
        }

        for (User user : users) {
            // Create an AnchorPane for each user
            AnchorPane userPane = new AnchorPane();
            userPane.setPrefSize(285, 120);
            // Set the background color of the userPane to #A8D6ED
            userPane.setBackground(new Background(new BackgroundFill(Color.web("#A8D6ED"), null, null)));

            // Add user email label
            Label emailLabel = new Label("Email: " + user.email);

            emailLabel.setLayoutX(1);
            emailLabel.setLayoutY(0);
            emailLabel.setStyle("-fx-font-size: 12px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;-fx-text-fill: black;");

            // Add pick location label
            Label pickLabel = new Label("Pick up:   " + "City: " + user.pick.city + "  " + "Area: " + user.pick.area + "\n" + "Town: " + user.pick.town + "   " + "Street #: " + user.pick.streetNo + "\n" + "House #: " + user.pick.houseNo);
            pickLabel.setLayoutX(1);
            pickLabel.setLayoutY(27);
            pickLabel.setStyle("-fx-font-size: 12px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;-fx-text-fill: black;");

            // Add drop location label
            Label dropLabel = new Label("Drop off:   " + "City: " + user.drop.city + "  " + "Area: " + user.drop.area + "\n" + "Town: " + user.drop.town + "   " + "Street #: " + user.drop.streetNo + "\n" + "House #: " + user.drop.houseNo);
            dropLabel.setLayoutX(1);
            dropLabel.setLayoutY(69);
            dropLabel.setStyle("-fx-font-size: 12px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;bold;-fx-text-fill: black;");

            // Add buttons
            Button acceptButton = new Button("✓");
            acceptButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-shape: 'M 10 10 A 10 10 0 1 1 20 10 A 10 10 0 1 1 10 10';");
            acceptButton.setLayoutX(93);
            acceptButton.setLayoutY(95);

            // Create a new AnchorPane for proposing fare
            AnchorPane fareProposalPane = new AnchorPane();
            fareProposalPane.setPrefSize(285, 126);
            fareProposalPane.setVisible(false);

            // Add "Propose Fare" label
            Label proposeFareLabel = new Label("Propose fare");
            proposeFareLabel.setLayoutX(84);
            proposeFareLabel.setLayoutY(1);
            proposeFareLabel.setStyle("-fx-font-size: 21px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;-fx-text-fill: black;");

            // Add "Enter amount" label
            Label enterAmountLabel = new Label("Enter amount");
            enterAmountLabel.setLayoutX(1);
            enterAmountLabel.setLayoutY(48);
            enterAmountLabel.setStyle("-fx-font-size: 12px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;-fx-text-fill: black;");

            // Add text field for entering fare
            TextField fareTextField = new TextField();
            fareTextField.setLayoutX(94);
            fareTextField.setLayoutY(44);
            fareTextField.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-radius: 24px;");

            // Add propose button
            Button proposeButton = new Button("✓");
            proposeButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-shape: 'M 10 10 A 10 10 0 1 1 20 10 A 10 10 0 1 1 10 10';");
            proposeButton.setLayoutX(120);
            proposeButton.setLayoutY(94);
            proposeButton.setOnAction(event -> {
                try {
                    // Add debug logging
                    double fare = Double.parseDouble(fareTextField.getText());

                    String emailD = SessionManager.currentDriver.email;
                    String emailU = user.email;
                    Booking booking = new Booking(emailD, emailU, fare);
                    ArrayList<Booking> bookings = new ArrayList<>();
                    File bookFile = new File("Booking.txt");

                    // Read existing bookings
                    if (bookFile.exists() && bookFile.length() > 0) {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(bookFile))) {
                            while (true) {
                                try {
                                    Booking existingBooking = (Booking) ois.readObject();
                                    bookings.add(existingBooking);
                                } catch (EOFException e) {
                                    break;
                                }
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                    // Add the new booking to the list
                    bookings.add(booking);

                    // Write all bookings back to the file
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookFile))) {
                        for (Booking b : bookings) {
                            oos.writeObject(b);
                        }
                    }

                    // Add debug logging
                    System.out.println("Propose button clicked for user: " + user.email);
                    System.out.println("Proposed fare: " + fareTextField.getText());

                } catch (IOException | NumberFormatException e) {
                    e.printStackTrace();
                }
            });

            Button declineButtonP = new Button("✗");
            declineButtonP.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-shape: 'M 10 10 A 10 10 0 1 1 20 10 A 10 10 0 1 1 10 10';");
            declineButtonP.setLayoutX(160);
            declineButtonP.setLayoutY(95);
            declineButtonP.setOnAction(event -> {
                fareProposalPane.setVisible(false);
                userPane.setVisible(false);

            });

            // Add components to fareProposalPane
            fareProposalPane.getChildren().addAll(proposeFareLabel, enterAmountLabel, fareTextField, proposeButton,declineButtonP);

            Button declineButton = new Button("✗");
            declineButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-shape: 'M 10 10 A 10 10 0 1 1 20 10 A 10 10 0 1 1 10 10';");
            declineButton.setLayoutX(160);
            declineButton.setLayoutY(95);
            declineButton.setOnAction(event -> {
                userPane.setVisible(false);

            });

            // Set action for acceptButton
            acceptButton.setOnAction(event -> {
                // Add debug logging
                fareProposalPane.setVisible(true);
                // Optionally, hide other elements
                emailLabel.setVisible(false);
                pickLabel.setVisible(false);
                dropLabel.setVisible(false);
                acceptButton.setVisible(false);
                declineButton.setVisible(false);
            });


            // Add all elements to the userPane
            userPane.getChildren().addAll(emailLabel, pickLabel, dropLabel, acceptButton, declineButton, fareProposalPane);

            // Add userPane to the parent container
            requestPane.getChildren().add(userPane);
        }
    }
    public void backS(MouseEvent mouseEvent) {
        searchR.setVisible(false);
    }

    public void backDp(javafx.event.ActionEvent event) {
        HelloApplication.stage1.setScene(DriverProfile.DP);
        HelloApplication.stage1.show();

    }

    public void confirmBook(MouseEvent mouseEvent) {
        confirmBookPane.setVisible(false);
    }
    public void cancelBook(MouseEvent mouseEvent) {

        cancelBookPane.setVisible(false);
    }
}
