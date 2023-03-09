package com.car.rental.service;

import com.car.rental.model.*;

import java.util.concurrent.CompletableFuture;

public class AdminService {
    private BookingService bookingService;

    public AdminService() {
        this.bookingService = new BookingService();
    }

    public CompletableFuture<Boolean> bookVehicle(Location location, VehicleType type, User user){
        return bookingService.bookVehicle(location,type,user);

    }

}
