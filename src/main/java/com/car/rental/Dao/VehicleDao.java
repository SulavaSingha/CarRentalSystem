package com.car.rental.Dao;

import com.car.rental.model.Vehicle;

import java.util.List;

public abstract class VehicleDao {
    abstract public void addVehiclesToStore(String id, List<Vehicle> list);
}
