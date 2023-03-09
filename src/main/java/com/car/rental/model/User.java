package com.car.rental.model;

public class User {
    private String id;
    private String name;
    private String drivingLicense;
    public User(String id, String name,String drivingLicense){
        this.id=id;
        this.name=name;
        this.drivingLicense=drivingLicense;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }
}
