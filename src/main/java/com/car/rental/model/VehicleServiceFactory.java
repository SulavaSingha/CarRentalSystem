package com.car.rental.model;

import com.car.rental.service.CarService;
import com.car.rental.service.VehicleService;

public class VehicleServiceFactory {
    public static VehicleService createVehicle(VehicleType type){
        switch(type){
            case CAR:
                return new CarService();
            default:
                throw new RuntimeException();

        }

    }
}
