package com.example.javafxtest;

import java.io.Serializable;

public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    String userName;
    String email;
    String password;
    String confrimPass;
    String phoneNo;
    String gender;
    double initialBalance;
    String vehicletype;
    String plateNo;
    String area;
    boolean booked;
    boolean cancelled;

    public Driver(String userName, String email, String password, String confrimPass, String phoneNo, String gender,String plateNo ,String vehicletype,String area) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confrimPass = confrimPass;
        this.phoneNo = phoneNo;
        this.gender = gender;
        initialBalance=0.0;
        this.vehicletype = vehicletype;
        this.plateNo = plateNo;
        this.area=area;
        this.booked=false;
        this.cancelled=false;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confrimPass='" + confrimPass + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", gender='" + gender + '\'' +
                ", initialBalance=" + initialBalance +
                ", vehicletype='" + vehicletype + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", area='" + area + '\'' +
                ", booked=" + booked +
                ", cancelled=" + cancelled +
                '}';
    }
}
