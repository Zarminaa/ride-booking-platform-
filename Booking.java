package com.example.javafxtest;

import java.io.Serializable;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    String emailD;
    String emailU;
    double fare;

    public Booking(String emailD, String emailU, double fare) {
        this.emailD = emailD;
        this.emailU = emailU;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "emailD='" + emailD + '\'' +
                ", emailU='" + emailU + '\'' +
                ", fare=" + fare +
                '}';
    }
}
