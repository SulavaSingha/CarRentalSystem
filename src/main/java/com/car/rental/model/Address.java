package com.car.rental.model;

public class Address {
    private String street;
    private String lane;

    public Address(String street, String lane) {
        this.street = street;
        this.lane = lane;
    }

    public String getStreet() {
        return street;
    }

    public String getLane() {
        return lane;
    }
}
