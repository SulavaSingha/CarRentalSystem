package com.car.rental.Dao;

import com.car.rental.model.VehicleType;
import com.car.rental.service.CarService;

public class VehicleDaoFactory {
    public static VehicleDao createDao(VehicleType type){
        switch(type){
            case CAR:
                return CarDao.getInstance();
            default:
                throw new RuntimeException();

        }

    }
}
