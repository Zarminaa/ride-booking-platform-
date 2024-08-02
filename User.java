package com.example.javafxtest;

import java.io.Serializable;


public class User implements Serializable  {
    private static final long serialVersionUID = 1L;

    String userName;
    String email;
    String password;
    String confrimPass;
    String phoneNo;
    String gender;
    double initialBalance;
    Address pick;
    Address drop;
    String vehicleType;
    Boolean book;
    Boolean booked;
    Boolean cancelled;
    public User(String userName, String email, String password, String confrimPass, String phoneNo, String gender, Address pick, Address drop, String vehicleType, Boolean book) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confrimPass = confrimPass;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.initialBalance = initialBalance;
        this.pick=pick;
        this.drop=drop;
        this.vehicleType=vehicleType;
        this.book=book;
        this.booked=false;
        this.cancelled=false;

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confrimPass='" + confrimPass + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", gender='" + gender + '\'' +
                ", initialBalance=" + initialBalance +
                ", pick=" + pick +
                ", drop=" + drop +
                ", vehicleType='" + vehicleType + '\'' +
                ", book=" + book +
                ", booked=" + booked +
                '}';
    }
}
