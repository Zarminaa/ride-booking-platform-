package com.example.javafxtest;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookU implements Initializable {
    @FXML
    Label noBooking;              //allow to see it when no booking has been done yet
    @FXML
    AnchorPane cancelBookPane;
    @FXML
    AnchorPane confirmBookPane;
    @FXML
    VBox requestPane;
    @FXML
    Label lessInfo;
    @FXML
    RadioButton carP;
    @FXML
    RadioButton carM;
    @FXML
    RadioButton rickshaw;
    @FXML
    RadioButton bike;
    @FXML
    ImageView carAc;
    @FXML
    ImageView carMini;
    @FXML
    ImageView ricky;
    @FXML
    ImageView biky;
    @FXML
    AnchorPane searchR;
    @FXML
    AnchorPane cancelPane;
    @FXML
    AnchorPane CCancelPane;


    private TranslateTransition t1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup t = new ToggleGroup();
        carP.setToggleGroup(t);
        carM.setToggleGroup(t);
        rickshaw.setToggleGroup(t);
        bike.setToggleGroup(t);

        t1 = new TranslateTransition();
        t1.setDuration(Duration.millis(2500));
        t1.setCycleCount(Animation.INDEFINITE);

        final double XCarA = carAc.getLayoutX();
        final double YCarA = carAc.getLayoutY();

        final double XCarM = carMini.getLayoutX();
        final double YCarM = carMini.getLayoutY();

        final double XRicky = ricky.getLayoutX();
        final double YRicky = ricky.getLayoutY();

        final double XBiky = biky.getLayoutX();
        final double YBiky = biky.getLayoutY();

        carP.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                carAc.setVisible(true);
                t1.setNode(carAc);
                t1.setByX(670);
                t1.play();
            } else {
                t1.stop();
                carAc.setLayoutX(XCarA);
                carAc.setLayoutY(YCarA);
                carAc.setVisible(false);
            }
        });

        carM.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                carMini.setVisible(true);
                t1.setNode(carMini);
                t1.setByX(670);
                t1.play();
            } else {
                t1.stop();
                carMini.setLayoutX(XCarM);
                carMini.setLayoutY(YCarM);
                carMini.setVisible(false);
            }
        });

        rickshaw.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                ricky.setVisible(true);
                t1.setNode(ricky);
                t1.setByX(670);
                t1.play();
            } else {
                t1.stop();
                ricky.setLayoutX(XRicky);
                ricky.setLayoutY(YRicky);
                ricky.setVisible(false);
            }
        });

        bike.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                biky.setVisible(true);
                t1.setNode(biky);
                t1.setByX(670);
                t1.play();
            } else {
                t1.stop();
                biky.setLayoutX(XBiky);
                biky.setLayoutY(YBiky);
                biky.setVisible(false);
            }
        });
        }



    public void backS(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        searchR.setVisible(false);

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
                user.book=false;
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
        System.out.println(SessionManager.currentUser.book);
    }

    public void cancelRide(MouseEvent mouseEvent) {
        if(!SessionManager.currentUser.booked){
          noBooking.setVisible(true);
        }else{cancelPane.setVisible(true);
        noBooking.setVisible(false);

        }
    }
    public void cYes(MouseEvent mouseEvent) throws IOException {
        noBooking.setVisible(false);
        cancelPane.setVisible(false);
        cancelBookPane.setVisible(true);
        CCancelPane.setVisible(true);
        storeCancelInfo();
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
                user.cancelled=true;
                user.booked=false;
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
        // Read all users from the file into an ArrayList
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverRepository.txt"))) {
            // users.add((User) ois.readObject());

            while (true) {
                try {
                    drivers.add((Driver) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    break; // Reached end of file
                }
            }
        }
        // Find the currently logged-in user and update its address
        for (Driver d : drivers) {

            if (d.email.equals(SessionManager.currentDriver.email)) {
                d.cancelled=true;
                d.booked=false;
                SessionManager.currentDriver = d;
                break;
            }
        }
        // Write all users back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
            for (Driver driver : drivers) {
                oos.writeObject(driver);
            }
        }

    }
    public void cNo(MouseEvent mouseEvent) {
        cancelPane.setVisible(false);
        noBooking.setVisible(false);
    }
    public void goBackFromC(MouseEvent mouseEvent) {
        CCancelPane.setVisible(false);
    }

  public void vehicleSelection(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        String type="";
        if(carP.isSelected()){
            type="premium";
        }
        else if (carM.isSelected()){
            type="car-mini";
        }
        else if(rickshaw.isSelected()){
            type="rickshaw";
        }
        else if(bike.isSelected()){
            type="bike";
        }
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
                user.vehicleType=type;
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

    }
    public void findDriver(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if (SessionManager.currentUser.pick == null ||
                SessionManager.currentUser.drop == null ||
                SessionManager.currentUser.vehicleType == null) {
            lessInfo.setVisible(true);
        } else {
            searchR.setVisible(true);
            lessInfo.setVisible(false);

                try {
                    // Read all users from the file into an ArrayList
                    ArrayList<User> users = new ArrayList<>();

                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
                        while (true) {
                            try {
                                users.add((User) ois.readObject());
                            } catch (EOFException e) {
                                break; // Reached end of file
                            }
                        }
                    }

                    // Find the currently logged-in user and update its book status
                    for (User user : users) {
                        if (user.email.equals(SessionManager.currentUser.email)) {
                            user.book = true;
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

                    // Read existing bookings from the file
                    ArrayList<Booking> bookings = new ArrayList<>();
                    File bookFile = new File("Booking.txt");

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

                    // Display bookings in the UI
                    for (Booking book : bookings) {
                        if (SessionManager.currentUser.email.equalsIgnoreCase(book.emailU)) {
                            SessionManager.fare=book.fare;
                            SessionManager.emailDriver=book.emailD;

                            // Create an AnchorPane for each user
                            AnchorPane userPane = new AnchorPane();
                            userPane.setPrefSize(200, 80);
                            // Set the background color of the userPane to #A8D6ED
                            userPane.setBackground(new Background(new BackgroundFill(Color.web("#8CB89F"), null, null)));
                            // Add user email label
                            Label emailLabel = new Label("Email: " + book.emailD);
                            emailLabel.setLayoutX(1);
                            emailLabel.setLayoutY(0);
                            emailLabel.setStyle("-fx-font-size: 19px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;-fx-text-fill: black;");
                            // Add pick location label
                            Label fareLabel = new Label("Fare:   $" + book.fare);
                            fareLabel.setLayoutX(1);
                            fareLabel.setLayoutY(27);
                            fareLabel.setStyle("-fx-font-size: 19px; -fx-font-family: 'Bell MT'; -fx-font-weight: bold;-fx-text-fill: black;");
                            // Add buttons
                            Button acceptButton = new Button("✓");
                            acceptButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-shape: 'M 10 10 A 10 10 0 1 1 20 10 A 10 10 0 1 1 10 10';");
                            acceptButton.setLayoutX(95);
                            acceptButton.setLayoutY(45);
                            acceptButton.setOnAction(event -> {
                                try {
                                    // Read all users from the file into an ArrayList
                                    ArrayList<User> users2 = new ArrayList<>();

                                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserRepository.txt"))) {
                                        while (true) {
                                            try {
                                                users2.add((User) ois.readObject());
                                            } catch (EOFException e) {
                                                break; // Reached end of file
                                            }
                                        }
                                    }

                                    // Find the currently logged-in user and update its book status
                                    for (User user : users2 ) {
                                        if (user.email.equals(SessionManager.currentUser.email)) {
                                            user.booked = true;
                                            user.book = true;
                                            SessionManager.currentUser = user;
                                            break;
                                        }
                                    }
                                    // Write all users back to the file
                                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserRepository.txt"))) {
                                        for (User user : users2) {
                                            oos.writeObject(user);
                                        }
                                    }
                                        // Update the driver.booked status in DriverRepository.txt
                                        ArrayList<Driver> drivers = new ArrayList<>();

                                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DriverRepository.txt"))) {
                                            while (true) {
                                                try {
                                                    drivers.add((Driver) ois.readObject());
                                                } catch (EOFException e) {
                                                    break; // Reached end of file
                                                }
                                            }
                                        }

                                        // Find the driver whose booking was confirmed and update their booked status
                                        for (Driver driver : drivers) {
                                            if (driver.email.equals(SessionManager.emailDriver)) {
                                                driver.booked = true;
                                                break;
                                            }
                                        }

                                        // Write all drivers back to the file
                                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DriverRepository.txt"))) {
                                            for (Driver driver : drivers) {
                                                oos.writeObject(driver);
                                            }
                                        }

                                    if (SessionManager.currentUser.booked) {
                                        confirmBookPane.setVisible(true);
                                        userPane.setVisible(false);
                                        storeUserInfo();
                                    }
                                } catch (IOException | ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            });


                            Button declineButtonP = new Button("✗");
                            declineButtonP.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-shape: 'M 10 10 A 10 10 0 1 1 20 10 A 10 10 0 1 1 10 10';");
                            declineButtonP.setLayoutX(125);
                            declineButtonP.setLayoutY(46);
                            declineButtonP.setOnAction(event -> {
                                userPane.setVisible(false);

                            });

                            // Add all elements to the userPane
                            userPane.getChildren().addAll(emailLabel, fareLabel, acceptButton, declineButtonP);

                            // Add userPane to the parent container
                            requestPane.getChildren().add(userPane);
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

        }
    }

    public void backUP(javafx.event.ActionEvent event) {
        HelloApplication.stage1.setScene(UserProfile.UP);
        HelloApplication.stage1.show();
    }
    public void storeUserInfo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("rideHistory.txt", true))) {
           writer.println(("Driver's Email:" + SessionManager.emailDriver));
           writer.println("Fare:" + SessionManager.fare);
            writer.println("User Name:" + SessionManager.currentUser.email);
            writer.println("User Email:" + SessionManager.currentUser.userName);
            writer.println("Vehicle Type:" + SessionManager.currentUser.vehicleType);
            writer.println("Pick Up Area"+  SessionManager.currentUser.pick.area);
            writer.println("Pick Up City:" + SessionManager.currentUser.pick.city);
            writer.println("Pick Up Pick Up street No:" + SessionManager.currentUser.pick.streetNo);
            writer.println("Pick Up House No:" + SessionManager.currentUser.pick.houseNo);
            writer.println("Pick Up Town:" + SessionManager.currentUser.pick.town);
            writer.println("Drop Off Area:" +  SessionManager.currentUser.drop.area);
            writer.println("Drop Off Town:" + SessionManager.currentUser.drop.town);
            writer.println("Drop Off City:" + SessionManager.currentUser.drop.city);
            writer.println("Drop Off House No:" + SessionManager.currentUser.drop.houseNo);
            writer.println("Drop Off Street No:" + SessionManager.currentUser.drop.streetNo);
            writer.println("--------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void confirmBook(MouseEvent mouseEvent) {
        confirmBookPane.setVisible(false);
    }
    public void storeCancelInfo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("cancelledRides.txt", true))) {
            writer.println("User Name:" + SessionManager.currentUser.userName);
            writer.println("User Email:" + SessionManager.currentUser.email);
            writer.println("Driver's Email:" + SessionManager.emailDriver);
            writer.println("Vehicle Type:" + SessionManager.currentUser.vehicleType);
            writer.println("Pick Up Area:" + SessionManager.currentUser.pick.area);
            writer.println("Pick Up City:" + SessionManager.currentUser.pick.city);
            writer.println("Pick Up Street No:" + SessionManager.currentUser.pick.streetNo);
            writer.println("Pick Up House No:" + SessionManager.currentUser.pick.houseNo);
            writer.println("Pick Up Town:" + SessionManager.currentUser.pick.town);
            writer.println("Drop Off Area:" + SessionManager.currentUser.drop.area);
            writer.println("Drop Off Town:" + SessionManager.currentUser.drop.town);
            writer.println("Drop Off City:" + SessionManager.currentUser.drop.city);
            writer.println("Drop Off House No:" + SessionManager.currentUser.drop.houseNo);
            writer.println("Drop Off Street No:" + SessionManager.currentUser.drop.streetNo);
            writer.println("--------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cancelBook(MouseEvent mouseEvent) {

        cancelBookPane.setVisible(false);
    }

}
