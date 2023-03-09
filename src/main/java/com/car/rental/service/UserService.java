package com.car.rental.service;

import com.car.rental.model.Location;
import com.car.rental.model.User;
import com.car.rental.model.VehicleType;

import java.util.concurrent.CompletableFuture;

public class UserService {
    private AdminService adminService;

    public UserService() {
        this.adminService = new AdminService();
    }

    public CompletableFuture<Boolean> bookVehicle(Location location, VehicleType type, User user){

        return adminService.bookVehicle(location,type,user);
    }

}
