package com.car.rental.model;

public class Store {
    private Location location;
    private String storeId;

    public Store(String storeId,Location location) {
        this.storeId = storeId;
        this.location=location;
    }


    public Location getLocation() {
        return location;
    }

    public String getStoreId() {
        return storeId;
    }
}
