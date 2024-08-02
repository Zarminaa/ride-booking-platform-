package com.example.javafxtest;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    public static Scene ULpage;
    public static Scene DLpage;
    @FXML
    ImageView car;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            TranslateTransition t1 = new TranslateTransition();
            t1.setDuration(Duration.millis(2500));
            t1.setNode(car);
            t1.setByX(670);
            t1.setCycleCount(Animation.INDEFINITE);
            t1.play();

    }

    @FXML
    public void onUserClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ULpage=scene;
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }
    @FXML
    public void onDriverClick(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("driver-start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        DLpage=scene;
        HelloApplication.stage1.setScene(scene);
        HelloApplication.stage1.show();
    }
}