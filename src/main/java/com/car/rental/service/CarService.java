package com.car.rental.service;

import com.car.rental.Dao.CarDao;
import com.car.rental.exception.StoreNotFoundException;
import com.car.rental.model.Car;
import com.car.rental.model.Location;
import com.car.rental.model.Store;
import com.car.rental.model.Vehicle;

import java.util.List;
import java.util.logging.Logger;

public class CarService extends VehicleService {

   private final CarDao carDao=CarDao.getInstance();

    @Override
    public Car getVehicleDetails(Location location) {
        try {
            Store store = getStoreDetails(location);
            List<Vehicle> carList = carDao.getAvailableCarList(store.getStoreId());
            System.out.println("car getting allocated:"+carList.get(0).getModel()+"car number: "+carList.get(0).getNumberPlate());
            return (Car) carList.get(0);
        }catch (StoreNotFoundException ex){
            Logger.getLogger(ex.getMessage());
            System.out.println(ex.getMessage());
        }

      return null;
    }

}
