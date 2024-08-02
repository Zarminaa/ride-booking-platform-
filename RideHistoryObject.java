package com.example.javafxtest;

public class RideHistoryObject {

    String userName;
    String userEmail;
    String driverEmail;
    String fare;
    String vehicleType;

    String pickUpArea;
    String pickUpCity;
    String pickUpStreetNo;
    String pickUpHouseNo;
    String pickUpTown;

    String dropOffArea;
    String dropOffTown;
    String dropOffCity;
    String dropOffHouseNo;
    String dropOffStreetNo;

    public RideHistoryObject(String userName, String userEmail, String driverEmail, String fare, String vehicleType, String pickUpArea, String pickUpCity, String pickUpStreetNo, String pickUpHouseNo, String pickUpTown, String dropOffArea, String dropOffTown, String dropOffCity, String dropOffHouseNo, String dropOffStreetNo) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.driverEmail = driverEmail;
        this.fare = fare;
        this.vehicleType = vehicleType;
        this.pickUpArea = pickUpArea;
        this.pickUpCity = pickUpCity;
        this.pickUpStreetNo = pickUpStreetNo;
        this.pickUpHouseNo = pickUpHouseNo;
        this.pickUpTown = pickUpTown;
        this.dropOffArea = dropOffArea;
        this.dropOffTown = dropOffTown;
        this.dropOffCity = dropOffCity;
        this.dropOffHouseNo = dropOffHouseNo;
        this.dropOffStreetNo = dropOffStreetNo;
    }
}

