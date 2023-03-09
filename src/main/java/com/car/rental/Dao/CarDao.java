package com.car.rental.Dao;

import com.car.rental.model.Car;
import com.car.rental.model.CarType;
import com.car.rental.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarDao extends VehicleDao {
    Map<CarType, List<Car>> vehicleMap;
    Map<String, List<Vehicle>> storeToCarMap;
    private static CarDao carDao;
    private CarDao(){
        this.vehicleMap = new ConcurrentHashMap<>();
        this.storeToCarMap =new ConcurrentHashMap<String, List<Vehicle>>();
    }
    public static CarDao getInstance(){
        if(carDao==null){
            carDao = new CarDao();
        }
        return carDao;
    }
    public List<Vehicle> getAvailableCarList(String storeId){
        List<Vehicle> carList =storeToCarMap.get(storeId);
        return carList;

    }

    public void removeCarFromList(String id,String storeId) {
        Car car = (Car) vehicleMap.get(id);
        vehicleMap.remove(id);
        List<Vehicle> carList=storeToCarMap.get(storeId);
        carList.remove(car);
    }

    @Override
    public void addVehiclesToStore(String storeId, List<Vehicle> carList) {
        storeToCarMap.put(storeId,carList);
        for(Vehicle car:carList){
            vehicleMap.putIfAbsent(car.getType(), new ArrayList<>());
            vehicleMap.get(car.getType()).add((Car) car);
        }
    }
    public int numberOfAvailableCar(CarType type){
        return vehicleMap.get(type).size();
    }
}
