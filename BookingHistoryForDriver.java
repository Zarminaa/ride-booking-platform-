package com.example.javafxtest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class BookingHistoryForDriver extends Application {

    private static ArrayList<RideHistoryObject> arrayListForCompletedRides = new ArrayList<>();

    private static ArrayList<RideHistoryObject> arrayListForCancelledRides = new ArrayList<>();
    private Scene scene;

    private static ArrayList<RideHistoryObject> arrayListForAllRides = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {

        readFromCompletedFile();
        readFromCancelledFile();
        copyArrayList();

        InputStream stream = new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\blueColor.png");
        Image image1 = new Image(stream);

        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);

        // Set up background image
        BackgroundImage backgroundImage1 = new BackgroundImage(
                image1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );

        InputStream stream2 = new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\blueArrow.png");
        Image image2 = new Image(stream2);

        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setFitHeight(50);
        imageView2.setFitWidth(70);

        InputStream stream3 = new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\allBlue.png");

        Image image3 = new Image(stream3);

        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);

        InputStream stream4 = new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\rickshawBlue2.image.png");

        Image image4 = new Image(stream4);

        ImageView imageView4 = new ImageView();
        imageView4.setImage(image4);

        InputStream stream5 =   new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\carMiniBlue.png");

        Image image5 = new Image(stream5);

        ImageView imageView5 = new ImageView();
        imageView5.setImage(image5);

        InputStream stream6 =  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\motorBikeBlue.png");


        Image image6 = new Image(stream6);

        ImageView imageView6 = new ImageView();
        imageView6.setImage(image6);

        InputStream stream7 =  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\premiumCarBlue.png");

        Image image7 = new Image(stream7);

        ImageView imageView7 = new ImageView();
        imageView7.setImage(image7);


        InputStream stream8 =  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\carMiniBlueR.image.png");

        Image image8 = new Image(stream8);

        InputStream stream9 =  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\blueMap.png");

        Image image9 = new Image(stream9);

        InputStream stream10=  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\blueLinedRickshaw.png");


        Image image10 = new Image(stream10);

        InputStream stream11 =  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\blueLinedBike.png");


        Image image11 = new Image(stream11);

        InputStream stream12 =  new FileInputStream("C:\\Java Programs\\javaFxTest\\src\\main\\resources\\blueLinedPremiumCar.png");

        Image image12 = new Image(stream12);

        Button arrowButton = new Button();
        arrowButton.setGraphic(imageView2);
        arrowButton.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");
        arrowButton.setLayoutX(12.9);
        arrowButton.setLayoutY(11.1);

        Text myBooking = new Text("My Bookings");
        myBooking.setStyle("-fx-fill:#1e4964");
        myBooking.setLayoutX(300);
        myBooking.setLayoutY(34.3);

        Button allButton = new Button();
        allButton.setGraphic(imageView3);
        allButton.setStyle("  -fx-border-color:#1e4964; -fx-background-color:#1e4964");
        allButton.setLayoutX(70.3);
        allButton.setLayoutY(96.9);

        Line lineForAllButton = new Line(60,130.3,98.3,130.3);
        lineForAllButton.setStrokeWidth(3);
        lineForAllButton.setLayoutX(23);
        lineForAllButton.setLayoutY(18);
        lineForAllButton.setStroke(Color.WHITE);
        lineForAllButton.setVisible(false);




        Button rickshawButton = new Button();
        rickshawButton.setGraphic(imageView4);
        rickshawButton.setStyle("  -fx-border-color:#1e4964; -fx-background-color:#1e4964");
        rickshawButton.setLayoutX(195.4);
        rickshawButton.setLayoutY(96.9);

        Line lineForRickshawButton = new Line(60,130.3,98.3,130.3);
        lineForRickshawButton.setStrokeWidth(3);
        lineForRickshawButton.setLayoutX(145);
        lineForRickshawButton.setLayoutY(18);
        lineForRickshawButton.setStroke(Color.WHITE);
        lineForRickshawButton.setVisible(false);

        Button carMiniButton = new Button();
        carMiniButton.setGraphic(imageView5);
        carMiniButton.setAlignment(Pos.CENTER_RIGHT);
        carMiniButton.setStyle("  -fx-border-color:#1e4964; -fx-background-color:#1e4964");
        carMiniButton.setLayoutX(309);
        carMiniButton.setLayoutY(96.9);

        Line lineForCarMiniButton = new Line(60,130.3,98.3,130.3);
        lineForCarMiniButton.setStrokeWidth(3);
        lineForCarMiniButton.setLayoutX(259);
        lineForCarMiniButton.setLayoutY(18);
        lineForCarMiniButton.setStroke(Color.WHITE);
        lineForCarMiniButton.setVisible(false);

        Button motorBikeButton = new Button();
        motorBikeButton.setGraphic(imageView6);
        motorBikeButton.setStyle("  -fx-border-color:#1e4964; -fx-background-color:#1e4964");
        motorBikeButton.setLayoutX(448.4);
        motorBikeButton.setLayoutY(96.9);

        Line lineForMotorBikeButton = new Line(60,130.3,98.3,130.3);
        lineForMotorBikeButton.setStrokeWidth(3);
        lineForMotorBikeButton.setLayoutX(400);
        lineForMotorBikeButton.setLayoutY(18);
        lineForMotorBikeButton.setStroke(Color.WHITE);
        lineForMotorBikeButton.setVisible(false);

        Button premiumCarButton = new Button();
        premiumCarButton.setGraphic(imageView7);
        premiumCarButton.setStyle("  -fx-border-color:#1e4964; -fx-background-color:#1e4964");
        premiumCarButton.setLayoutX(571.9);
        premiumCarButton.setLayoutY(96.9);

        Line lineForPremiumCarButton = new Line(60,130.3,98.3,130.3);
        lineForPremiumCarButton.setStrokeWidth(3);
        lineForPremiumCarButton.setLayoutX(524);
        lineForPremiumCarButton.setLayoutY(18);
        lineForPremiumCarButton.setStroke(Color.WHITE);
        lineForPremiumCarButton.setVisible(false);


        Button completedButton = new Button();
        completedButton.setText("Completed");
        completedButton.setPrefWidth(150);
        completedButton.setStyle("-fx-background-color:#1e4964; -fx-border-color:#1e4964;-fx-text-fill:#ABD0C7");
        completedButton.setLayoutX(28);
        completedButton.setLayoutY(163.7);

        Circle circleForCompletedButton = new Circle();
        circleForCompletedButton.setRadius(4);
        circleForCompletedButton.setFill(Color.WHITE);
        circleForCompletedButton.setLayoutX(100);
        circleForCompletedButton.setLayoutY(200);
        circleForCompletedButton.setVisible(false);

        Button cancelledButton = new Button();
        cancelledButton.setText("Cancelled");
        cancelledButton.setPrefWidth(150);
        cancelledButton.setAlignment(Pos.CENTER_RIGHT);
        cancelledButton.setStyle("-fx-background-color:#1e4964; -fx-border-color:#1e4964; -fx-text-fill:#ABD0C7");
        cancelledButton.setLayoutX(495);
        cancelledButton.setLayoutY(163.7);

        Circle circleForCancelledButton = new Circle();
        circleForCancelledButton.setRadius(4);
        circleForCancelledButton.setFill(Color.WHITE);
        circleForCancelledButton.setLayoutX(611);
        circleForCancelledButton.setLayoutY(200);
        circleForCancelledButton.setVisible(false);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(new Background(backgroundImage1));
        anchorPane.getChildren().addAll(myBooking,arrowButton,allButton,rickshawButton,carMiniButton,motorBikeButton,premiumCarButton,completedButton,cancelledButton);

        anchorPane.getChildren().addAll(lineForAllButton,lineForRickshawButton,lineForCarMiniButton,lineForMotorBikeButton,lineForPremiumCarButton);
        anchorPane.getChildren().addAll(circleForCompletedButton,circleForCancelledButton);

        scene = new Scene(anchorPane, 680, 600);
        stage.setScene(scene);
        stage.show();

        arrowButton.setOnAction(event -> {
            stage.close();

            // Start the MessageGreen screen
            HelloApplication.stage1.setScene(DriverProfile.DP);
            HelloApplication.stage1.show();
        });


        allButton.setOnAction(event -> {

            circleForCompletedButton.setVisible(false);
            circleForCancelledButton.setVisible(false);

            lineForAllButton.setVisible(true);

            if(lineForAllButton.isVisible()) {
                lineForRickshawButton.setVisible(false);
                lineForCarMiniButton.setVisible(false);
                lineForMotorBikeButton.setVisible(false);
                lineForPremiumCarButton.setVisible(false);
            }

            Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
            rectangle.setWidth(680);
            rectangle.setHeight(381.6);
            rectangle.setLayoutX(0);
            rectangle.setLayoutY(218.4);



            double buttonY = 10;
            double roundButtonY = 30;


            VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
            buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
            buttonContainer.setSpacing(20); // Set spacing between buttons
            buttonContainer.setPadding(new Insets(15,0,18,0));

            Text textForNoBooking = new Text("No Bookings Available");
            textForNoBooking.setLayoutX(275);
            textForNoBooking.setLayoutY(350);
            textForNoBooking.setFill(Color.BLACK);
            textForNoBooking.setVisible(false);

            if(arrayListForAllRides.size() == 0)
            {
                textForNoBooking.setVisible(true);

            }

            for (int i = 1; i <= arrayListForAllRides.size(); i++) {



                RideHistoryObject rideHistoryObject = arrayListForAllRides.get(i-1);

                Button roundButton = new Button();
                roundButton.setStyle("-fx-background-color:pink");
                roundButton.setTranslateY(roundButtonY);
                ImageView imageViewForRoundButton = new ImageView();
                if(rideHistoryObject.vehicleType.equals("car-mini")) {
                    imageViewForRoundButton.setImage(image8);
                } else if (rideHistoryObject.vehicleType.equals("bike")) {
                    imageViewForRoundButton.setImage(image11);
                } else if (rideHistoryObject.vehicleType.equals("premium car")) {

                    imageViewForRoundButton.setImage(image12);

                }
                else {
                    imageViewForRoundButton.setImage(image10);
                }
                roundButton.setGraphic(imageViewForRoundButton);
                roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                Button button = new Button();
                button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                button.setPrefHeight(100);
                button.setTextFill(Color.WHITE);
                button.setPrefWidth(240);
                button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                button.setOnAction(event1 -> {

                    ImageView imageViewForPopUp = new ImageView();
                    imageViewForPopUp.setImage(image9);

                    Rectangle rectangleForPopUp = new Rectangle(350,260);
                    rectangleForPopUp.setStyle("-fx-fill:#325164 ");
                    rectangleForPopUp.setArcWidth(25);
                    rectangleForPopUp.setArcHeight(25);


                    Text text = new Text();
                    text.setFill(Color.WHITE);
                    text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  + "Fare: " + rideHistoryObject.fare);

                    StackPane stackPaneForText = new StackPane();
                    stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                    BorderPane borderPane = new BorderPane();
                    borderPane.setBottom(stackPaneForText);
                    BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                    Text completedLabel = new Text();
                    completedLabel.setText("Completed");
                    completedLabel.setFill(Color.WHITE);
                    completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                    Text location1 = new Text();
                    location1.setText(rideHistoryObject.pickUpCity);
                    location1.setFill(Color.WHITE);
                    location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                    Text location2 = new Text();
                    location2.setText(rideHistoryObject.dropOffCity);
                    location2.setFill(Color.WHITE);
                    location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                    location1.setTranslateY(-12); // Move location1 up by 10 pixels
                    location2.setTranslateY(-12); // Move location2 up by 10 pixels


                    HBox hBox = new HBox();
                    hBox.getChildren().addAll(location1,location2);

                    hBox.setAlignment(Pos.CENTER);
                    hBox.setSpacing(90);
                    hBox.setMouseTransparent(true);

                    Button arrowButtonInside = new Button();
                    arrowButtonInside.setGraphic(imageView2);
                    arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                    BorderPane borderPaneForCompletedLabel = new BorderPane();
                    borderPaneForCompletedLabel.setTop(completedLabel);
                    borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                    BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                    BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                    arrowButtonInside.setOnAction(event2 -> {

                        stage.setScene(scene);
                        stage.show();
                    });


                    StackPane stackPane = new StackPane();
                    stackPane.setPadding(new Insets(5,0,5,0));
                    stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                    Scene sceneForPopUp = new Scene(stackPane,680,600);
                    stage.setScene(sceneForPopUp);
                    stage.show();

                });

                buttonContainer.getChildren().add(roundButton);
                buttonContainer.getChildren().add(button);

            }

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(buttonContainer);
            scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
            scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

            // Set the position of the ScrollPane
            AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
            AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

            anchorPane.getChildren().addAll(rectangle,scrollPane);
            anchorPane.getChildren().addAll(textForNoBooking);

        });

        rickshawButton.setOnAction(event -> {



            lineForRickshawButton.setVisible(true);

            if (lineForRickshawButton.isVisible()) {
                lineForAllButton.setVisible(false);
                lineForCarMiniButton.setVisible(false);
                lineForMotorBikeButton.setVisible(false);
                lineForPremiumCarButton.setVisible(false);
            }


            completedButton.setOnAction(event1 -> {




                circleForCompletedButton.setVisible(true);

                if (circleForCompletedButton.isVisible()) {
                    circleForCancelledButton.setVisible(false);
                }


                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));






                for (int i = 1; i <= arrayListForCompletedRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCompletedRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("bike") || (rideHistoryObject.vehicleType).equals("car-mini") || (rideHistoryObject.vehicleType).equals("premium car"))
                    {
                        continue;
                    }

                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image10);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  + "Fare: " + rideHistoryObject.fare);

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Completed");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);





            });

            completedButton.fire();





            cancelledButton.setOnAction(event1 -> {



                circleForCancelledButton.setVisible(true);

                if (circleForCancelledButton.isVisible()) {
                    circleForCompletedButton.setVisible(false);
                }

                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCancelledRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCancelledRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("bike") || (rideHistoryObject.vehicleType).equals("car-mini") || (rideHistoryObject.vehicleType).equals("premium car"))
                    {
                        continue;
                    }


                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image10);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  );

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Cancelled");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);


            });


        });

        carMiniButton.setOnAction(event -> {
            lineForCarMiniButton.setVisible(true);

            if(lineForCarMiniButton.isVisible()) {
                lineForAllButton.setVisible(false);
                lineForRickshawButton.setVisible(false);
                lineForMotorBikeButton.setVisible(false);
                lineForPremiumCarButton.setVisible(false);
            }

            completedButton.setOnAction(event1 -> {




                circleForCompletedButton.setVisible(true);

                if (circleForCompletedButton.isVisible()) {
                    circleForCancelledButton.setVisible(false);
                }


                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCompletedRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCompletedRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("bike") || (rideHistoryObject.vehicleType).equals("rickshaw") || (rideHistoryObject.vehicleType).equals("premium car"))
                    {
                        continue;
                    }


                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image8);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  + "Fare: " + rideHistoryObject.fare);

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Completed");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);



            });

            completedButton.fire();



            cancelledButton.setOnAction(event1 -> {



                circleForCancelledButton.setVisible(true);

                if (circleForCancelledButton.isVisible()) {
                    circleForCompletedButton.setVisible(false);
                }

                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCancelledRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCancelledRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("bike") || (rideHistoryObject.vehicleType).equals("rickshaw") || (rideHistoryObject.vehicleType).equals("premium car"))
                    {
                        continue;
                    }




                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image8);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  );

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Cancelled");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);



            });

        });

        motorBikeButton.setOnAction(event -> {
            lineForMotorBikeButton.setVisible(true);

            if (lineForMotorBikeButton.isVisible()) {
                lineForAllButton.setVisible(false);
                lineForRickshawButton.setVisible(false);
                lineForCarMiniButton.setVisible(false);
                lineForPremiumCarButton.setVisible(false);
            }

            completedButton.setOnAction(event1 -> {




                circleForCompletedButton.setVisible(true);

                if (circleForCompletedButton.isVisible()) {
                    circleForCancelledButton.setVisible(false);
                }


                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCompletedRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCompletedRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("car-mini") || (rideHistoryObject.vehicleType).equals("rickshaw") || (rideHistoryObject.vehicleType).equals("premium car"))
                    {
                        continue;
                    }


                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image11);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  + "Fare: " + rideHistoryObject.fare);

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Completed");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);



            });

            completedButton.fire();



            cancelledButton.setOnAction(event1 -> {


                circleForCancelledButton.setVisible(true);

                if (circleForCancelledButton.isVisible()) {
                    circleForCompletedButton.setVisible(false);
                }

                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCancelledRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCancelledRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("car-mini") || (rideHistoryObject.vehicleType).equals("rickshaw") || (rideHistoryObject.vehicleType).equals("premium car"))
                    {
                        continue;
                    }


                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image11);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  );

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Cancelled");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);



            });



        });

        premiumCarButton.setOnAction(event -> {

            lineForPremiumCarButton.setVisible(true);

            if (lineForPremiumCarButton.isVisible()) {
                lineForAllButton.setVisible(false);
                lineForRickshawButton.setVisible(false);
                lineForCarMiniButton.setVisible(false);
                lineForMotorBikeButton.setVisible(false);
            }

            completedButton.setOnAction(event1 -> {




                circleForCompletedButton.setVisible(true);

                if (circleForCompletedButton.isVisible()) {
                    circleForCancelledButton.setVisible(false);
                }


                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCompletedRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCompletedRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("car-mini") || (rideHistoryObject.vehicleType).equals("rickshaw") || (rideHistoryObject.vehicleType).equals("bike"))
                    {
                        continue;
                    }


                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image12);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  + "Fare: " + rideHistoryObject.fare);

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Completed");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);



            });

            completedButton.fire();


            cancelledButton.setOnAction(event1 -> {



                circleForCancelledButton.setVisible(true);

                if (circleForCancelledButton.isVisible()) {
                    circleForCompletedButton.setVisible(false);
                }

                Rectangle rectangle = new Rectangle(0,0,Color.LIGHTBLUE);
                rectangle.setWidth(680);
                rectangle.setHeight(381.6);
                rectangle.setLayoutX(0);
                rectangle.setLayoutY(218.4);



                double buttonY = 10;
                double roundButtonY = 30;


                VBox buttonContainer = new VBox(); // Create a VBox to hold the buttons
                buttonContainer.setAlignment(Pos.CENTER); // Set alignment to center
                buttonContainer.setSpacing(20); // Set spacing between buttons
                buttonContainer.setPadding(new Insets(15,0,18,0));




                for (int i = 1; i <= arrayListForCancelledRides.size(); i++) {

                    RideHistoryObject rideHistoryObject = arrayListForCancelledRides.get(i-1);

                    if((rideHistoryObject.vehicleType).equals("car-mini") || (rideHistoryObject.vehicleType).equals("rickshaw") || (rideHistoryObject.vehicleType).equals("bike"))
                    {
                        continue;
                    }


                    Button roundButton = new Button();
                    roundButton.setStyle("-fx-background-color:pink");
                    roundButton.setTranslateY(roundButtonY);
                    ImageView imageViewForRoundButton = new ImageView();
                    imageViewForRoundButton.setImage(image12);
                    roundButton.setGraphic(imageViewForRoundButton);
                    roundButton.setStyle("-fx-background-radius:25; -fx-border-radius:25; -fx-background-color:#ffffff");


                    Button button = new Button();
                    button.setTextFill(Color.WHITE);
                    button.setText(rideHistoryObject.userName + "\n" + rideHistoryObject.driverEmail + "\n" + rideHistoryObject.vehicleType);
                    button.setPrefHeight(100);
                    button.setPrefWidth(240);
                    button.setStyle("-fx-background-color:#325164; -fx-border-color:#325164; -fx-background-radius:10; -fx-border-radius:10");

                    button.setOnAction(event2 -> {

                        ImageView imageViewForPopUp = new ImageView();
                        imageViewForPopUp.setImage(image9);

                        Rectangle rectangleForPopUp = new Rectangle(350,260);
                        rectangleForPopUp.setStyle("-fx-fill:#325164");
                        rectangleForPopUp.setArcWidth(25);
                        rectangleForPopUp.setArcHeight(25);


                        Text text = new Text();
                        text.setFill(Color.WHITE);
                        text.setText("\t\t\t\t\t TriPiFy   \n\n" + "Pick up Location: " + rideHistoryObject.pickUpHouseNo + " " +rideHistoryObject.pickUpStreetNo + " " +rideHistoryObject.pickUpArea + " " + rideHistoryObject.pickUpTown + " " +rideHistoryObject.pickUpCity + " \n" + "Drop off Location: " + rideHistoryObject.dropOffHouseNo + " " + rideHistoryObject.dropOffStreetNo + " " + rideHistoryObject.dropOffArea + " " + rideHistoryObject.dropOffTown + " " + rideHistoryObject.dropOffCity + "\n \n" + " Vehicle: " +rideHistoryObject.vehicleType + "\n"  );

                        StackPane stackPaneForText = new StackPane();
                        stackPaneForText.getChildren().addAll(rectangleForPopUp,text);

                        BorderPane borderPane = new BorderPane();
                        borderPane.setBottom(stackPaneForText);
                        BorderPane.setAlignment(rectangleForPopUp,Pos.BOTTOM_CENTER);


                        Text completedLabel = new Text();
                        completedLabel.setText("Cancelled");
                        completedLabel.setFill(Color.WHITE);
                        completedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18)); // Set font size and weight

                        Text location1 = new Text();
                        location1.setText(rideHistoryObject.pickUpCity);
                        location1.setFill(Color.WHITE);
                        location1.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        Text location2 = new Text();
                        location2.setText(rideHistoryObject.dropOffCity);
                        location2.setFill(Color.WHITE);
                        location2.setFont(Font.font("Arial", FontWeight.BOLD, 20));

                        location1.setTranslateY(-12); // Move location1 up by 10 pixels
                        location2.setTranslateY(-12); // Move location2 up by 10 pixels


                        HBox hBox = new HBox();
                        hBox.getChildren().addAll(location1,location2);

                        hBox.setAlignment(Pos.CENTER);
                        hBox.setSpacing(90);
                        hBox.setMouseTransparent(true);

                        Button arrowButtonInside = new Button();
                        arrowButtonInside.setGraphic(imageView2);
                        arrowButtonInside.setStyle("-fx-border-color:#1e4964; -fx-background-color:#1e4964");


                        BorderPane borderPaneForCompletedLabel = new BorderPane();
                        borderPaneForCompletedLabel.setTop(completedLabel);
                        borderPaneForCompletedLabel.setLeft(arrowButtonInside);
                        BorderPane.setAlignment(completedLabel,Pos.TOP_CENTER);
                        BorderPane.setAlignment(arrowButtonInside,Pos.TOP_LEFT);

                        arrowButtonInside.setOnAction(event3 -> {

                            stage.setScene(scene);
                            stage.show();
                        });


                        StackPane stackPane = new StackPane();
                        stackPane.setPadding(new Insets(5,0,5,0));
                        stackPane.getChildren().addAll(imageViewForPopUp,borderPane,borderPaneForCompletedLabel,hBox);

                        Scene sceneForPopUp = new Scene(stackPane,680,600);
                        stage.setScene(sceneForPopUp);
                        stage.show();

                    });

                    buttonContainer.getChildren().add(roundButton);
                    buttonContainer.getChildren().add(button);

                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(buttonContainer);
                scrollPane.setPrefSize(680, 381.6); // Set the preferred size of the ScrollPane
                scrollPane.setFitToWidth(true); // Adjusts the width of the ScrollPane to fit its content

                // Set the position of the ScrollPane
                AnchorPane.setLeftAnchor(scrollPane, 0.0); // Set left anchor to center horizontally
                AnchorPane.setTopAnchor(scrollPane, 218.4); // Set top anchor

                anchorPane.getChildren().addAll(rectangle,scrollPane);



            });



        });


        allButton.fire();
    }

    public static void readFromCompletedFile() {

        String userName = "";
        String userEmail = "";
        String driverEmail = "";
        String fare = "";
        String vehicleType = "";

        String pickUpArea = "";
        String pickUpCity = "";
        String pickUpStreetNo = "";
        String pickUpHouseNo = "";
        String pickUpTown = "";

        String dropOffArea = "";
        String dropOffTown = "";
        String dropOffCity = "";
        String dropOffHouseNo = "";
        String dropOffStreetNo = "";

        try {
            File file = new File("rideHistory.txt ");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.toLowerCase().contains("user name")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();

                        userName = value;

                    }
                } else if (line.toLowerCase().contains("user email")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();

                        userEmail = value;
                    }
                } else if (line.toLowerCase().contains("vehicle type")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();

                        vehicleType = value;
                    }
                }  else if (line.toLowerCase().contains("fare")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        fare = value;
                    }
                } else if (line.toLowerCase().contains("driver's email")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        driverEmail = value;
                    }
                }  else if (line.toLowerCase().contains("pick up area")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpArea = value;
                    }
                }else if (line.toLowerCase().contains("pick up city")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpCity = value;
                    }
                }
                else if (line.toLowerCase().contains("pick up street no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpStreetNo = value;
                    }
                }
                else if (line.toLowerCase().contains("pick up house no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpHouseNo = value;
                    }
                }
                else if (line.toLowerCase().contains("pick up town")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpTown = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off area")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffArea = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off town")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffTown = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off city")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffCity = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off house no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffHouseNo = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off street no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffStreetNo = value;
                    }
                }else if (line.contains("-------------")) {


                    RideHistoryObject rideHistoryObject = new RideHistoryObject(userName,userEmail,driverEmail,fare,vehicleType,pickUpArea,pickUpCity,pickUpStreetNo,pickUpHouseNo,pickUpTown,dropOffArea,dropOffTown,dropOffCity,dropOffHouseNo,dropOffStreetNo);

                    arrayListForCompletedRides.add(rideHistoryObject);



                }

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
        }
    }

    public static void readFromCancelledFile() {

        String userName = "";
        String userEmail = "";
        String driverEmail = "";
        String fare = "";
        String vehicleType = "";

        String pickUpArea = "";
        String pickUpCity = "";
        String pickUpStreetNo = "";
        String pickUpHouseNo = "";
        String pickUpTown = "";

        String dropOffArea = "";
        String dropOffTown = "";
        String dropOffCity = "";
        String dropOffHouseNo = "";
        String dropOffStreetNo = "";

        try {
            File file = new File("cancelledRides.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.toLowerCase().contains("user name")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();

                        userName = value;

                    }
                } else if (line.toLowerCase().contains("user email")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();

                        userEmail = value;
                    }
                } else if (line.toLowerCase().contains("vehicle type")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();

                        vehicleType = value;
                    }
                }   else if (line.toLowerCase().contains("driver's email")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        driverEmail = value;
                    }
                }  else if (line.toLowerCase().contains("pick up area")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpArea = value;
                    }
                }else if (line.toLowerCase().contains("pick up city")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpCity = value;
                    }
                }
                else if (line.toLowerCase().contains("pick up street no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpStreetNo = value;
                    }
                }
                else if (line.toLowerCase().contains("pick up house no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpHouseNo = value;
                    }
                }
                else if (line.toLowerCase().contains("pick up town")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        pickUpTown = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off area")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffArea = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off town")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffTown = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off city")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffCity = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off house no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffHouseNo = value;
                    }
                }
                else if (line.toLowerCase().contains("drop off street no")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String value = parts[1].trim();

                        dropOffStreetNo = value;
                    }
                }else if (line.contains("-------------")) {


                    RideHistoryObject rideHistoryObject = new RideHistoryObject(userName,userEmail,driverEmail,fare,vehicleType,pickUpArea,pickUpCity,pickUpStreetNo,pickUpHouseNo,pickUpTown,dropOffArea,dropOffTown,dropOffCity,dropOffHouseNo,dropOffStreetNo);

                    arrayListForCancelledRides.add(rideHistoryObject);



                }

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
        }
    }

    public void copyArrayList()
    {
        arrayListForAllRides.addAll(arrayListForCompletedRides);
        arrayListForAllRides.addAll(arrayListForCancelledRides);
    }


}


