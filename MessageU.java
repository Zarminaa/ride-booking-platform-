package com.example.javafxtest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessageU extends Application {
    private VBox messageBox;
    private Stage primaryStage;

    public MessageU() {}

    public MessageU(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        if (primaryStage == null) {
            primaryStage = stage;
        }

        // Load the image
        InputStream input = getClass().getResourceAsStream("/Messages.png");
        if (input == null) {
            throw new FileNotFoundException("Resource Messages.png not found");
        }
Image image = new Image(input);
        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(680); // Set the width of the ImageView
        imageView.setFitHeight(600); // Set the height of the ImageView
        imageView.setPreserveRatio(true);

        InputStream arrowInput = getClass().getResourceAsStream("/Arrow.PNG");
        if (arrowInput == null) {
            throw new FileNotFoundException("Resource Arrow.PNG not found");
        }
        Image arrowImage = new Image(arrowInput);
        ImageView arrowImageView = new ImageView(arrowImage);
        arrowImageView.setFitWidth(40); // Set the width of the ImageView
        arrowImageView.setFitHeight(40); // Set the height of the ImageView
        arrowImageView.setPreserveRatio(true);

        Button buttonM = new Button();
        buttonM.setGraphic(arrowImageView);
        buttonM.setBackground(null); // Remove default button background

        buttonM.setOnAction(event -> {
            // Close the current stage
            stage.close();
            // Start the MessageGreen screen
            HelloApplication.stage1.setScene(UserProfile.UP);
            HelloApplication.stage1.show();
        });


        // Create a VBox to hold the messages
        messageBox = new VBox(10);
        messageBox.setPadding(new Insets(50));
        messageBox.setAlignment(Pos.BOTTOM_LEFT);

        // Load existing messages from files
        loadMessagesFromFile("C:\\Java Programs\\javaFxTest\\MessageUser.txt");
        loadMessagesFromFile("C:\\Java Programs\\javaFxTest\\MessageDriver.txt");

        // Create a TextField
        TextField textField = new TextField();
        textField.setPromptText("Enter your message here");
        textField.setPrefSize(600, 50); // Set the preferred width and height
        textField.setStyle("-fx-background-color: transparent; " +
                "-fx-border-color: #00221C; " + // Border color
                "-fx-border-radius: 10;");
        textField.setPadding(new Insets(0, 0, 20, 0));

        // Create a Send button
        Button sendButton = new Button("Send");
        sendButton.setStyle("-fx-background-color: #00221C;");
        sendButton.setStyle("-fx-font-size: 12pt;"); // Initial font size

        // Event handler to change button style when mouse enters
        sendButton.setOnMouseEntered(e -> {
            sendButton.setStyle("-fx-font-size: 12pt; " + // Increased font size
                    "-fx-background-color: #1e4964;"); // Lighter background color
        });

        // Event handler to change button style when mouse exits
        sendButton.setOnMouseExited(e -> {
            sendButton.setStyle("-fx-font-size: 12pt;"); // Restore initial font size
        });

        // Set button shape (oval)
        sendButton.setShape(new Circle(40));

        // Set button size
        sendButton.setMinSize(60, 60);
        sendButton.setMaxSize(60, 60);

        sendButton.setOnAction(event -> {
            String message = textField.getText().trim();
            if (!message.isEmpty()) {
                // Save the message to a file and display it
                saveMessageToFile(message, "C:\\Java Programs\\javaFxTest\\MessageUser.txt");
                displayMessage(message, LocalDateTime.now(), true);
                textField.clear(); // Clear the TextField after sending
            }
        });

        // Create an HBox to hold the TextField and Send button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(textField, sendButton);
        hBox.setAlignment(Pos.CENTER_RIGHT); // Align items to the right

        // Create a StackPane to layer the background image and message box
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, messageBox, buttonM); // Add buttonM to the StackPane
        StackPane.setAlignment(imageView, Pos.CENTER);
        StackPane.setAlignment(messageBox, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(buttonM, Pos.TOP_LEFT); // Align buttonM to the top left corner
        buttonM.setTranslateX(20);
        buttonM.setTranslateY(60);

        // Create a VBox to hold the StackPane and HBox
        VBox vBox = new VBox();
        vBox.getChildren().addAll(stackPane, hBox);
        vBox.setAlignment(Pos.BOTTOM_CENTER); // Align items to the bottom
        // Create the Scene
        Scene scene = new Scene(vBox, 680, 600);

        // Set the Scene to the Stage
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();



        // Set the Scene to the Stage
        primaryStage.setScene(scene);

        // Set the title of the Stage
        primaryStage.setTitle("Messages");

        // Show the Stage
        primaryStage.show();
    }

    private void saveMessageToFile(String messageContent, String filePath) {
        LocalDateTime timestamp = LocalDateTime.now();
        MessageClass message = new MessageClass(messageContent, timestamp);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(message); // Write the message object to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMessage(String messageContent, LocalDateTime timestamp, boolean isSent) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedTimestamp = timestamp.format(formatter);
        Label messageLabel = new Label(messageContent + "\n" + formattedTimestamp);
        messageLabel.setStyle(isSent ? "-fx-background-color: #DCF8C6; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 10;"
                : "-fx-background-color: #E6E6E6; -fx-padding: 10; -fx-border-radius: 10; -fx-background-radius: 10;");
        messageBox.getChildren().add(messageLabel);
    }

    private void loadMessagesFromFile(String filePath) {
        List<MessageClass> messages = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    MessageClass message = (MessageClass) inputStream.readObject();
                    messages.add(message);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (MessageClass message : messages) {
            displayMessage(message.getContent(), message.getTimestamp(), filePath.contains("MessagesUser.txt"));
        }
    }

}