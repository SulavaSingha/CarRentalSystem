package com.car.rental.service;

import com.car.rental.exception.StoreNotFoundException;
import com.car.rental.model.Location;
import com.car.rental.model.Store;
import com.car.rental.model.Vehicle;

public abstract class VehicleService {
    StoreService storeService;
    public VehicleService(){
        this.storeService=new StoreService();
    }
    abstract Vehicle getVehicleDetails(Location location);
    public Store getStoreDetails(Location location) throws StoreNotFoundException {
        return storeService.getStoreDetails(location.getId());
    }
}
