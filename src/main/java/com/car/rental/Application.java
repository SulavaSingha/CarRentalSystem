package com.car.rental;

import com.car.rental.Dao.UserDao;
import com.car.rental.model.*;
import com.car.rental.service.AdminService;
import com.car.rental.service.BookingService;
import com.car.rental.service.SystemAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

public class Application {
    public static void main(String[] args) {
        SystemAdmin.addCarToSystem();
        List<User> users = SystemAdmin.getInstance().addUsers();
        List<Store> stores =SystemAdmin.addStore();
        BookingService bookingService = new BookingService();
        Location location=new Location("Ind123", new Address("Indiranagar", "80feet"));
        User user = SystemAdmin.getUser(users.get(0).getDrivingLicense());
        CompletableFuture<Boolean> booked = bookingService.bookVehicle(location, VehicleType.CAR,user );
        User user1 =SystemAdmin.getUser(users.get(1).getDrivingLicense());
        CompletableFuture<Boolean> booked1 = bookingService.bookVehicle(location, VehicleType.CAR,user1 );

    }




}
