package com.example.javafxtest;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    String city;
    String area;
    String town;
    String streetNo;
    String houseNo;

    public Address(String city, String area, String town, String streetNo, String houseNo) {
        this.city = city;
        this.area = area;
        this.town = town;
        this.streetNo = streetNo;
        this.houseNo = houseNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", town='" + town + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", houseNo='" + houseNo + '\'' +
                '}';
    }
}
