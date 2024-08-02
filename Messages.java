package com.example.javafxtest;

import com.example.javafxtest.MessageDriver;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Messages extends Application {
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Start with the MessageBlue screen
        new MessageDriver(primaryStage).start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}