package com.car.rental.model;

public class Location {
    private String id;
    private Address address;

    public Location(String id, Address address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }
}
