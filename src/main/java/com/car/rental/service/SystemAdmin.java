package com.car.rental.service;

import com.car.rental.Dao.StoreDao;
import com.car.rental.Dao.UserDao;
import com.car.rental.Dao.VehicleDao;
import com.car.rental.Dao.VehicleDaoFactory;
import com.car.rental.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SystemAdmin {
    private VehicleDao vehicleDao;
    private static SystemAdmin systemAdmin=null;
    private SystemAdmin() {
    }
    public static SystemAdmin getInstance(){
        if(systemAdmin==null){
            systemAdmin = new SystemAdmin();
        }
        return systemAdmin;
    }

    public void addVehiclesToStore(VehicleType type, String storeId, List<Vehicle> vehicleList) {
        this.vehicleDao = VehicleDaoFactory.createDao(type);
        vehicleDao.addVehiclesToStore(storeId, vehicleList);
    }
    public static void addCarToSystem() {
        List<Vehicle> carSwiftList = new CopyOnWriteArrayList<>();
        Car swift1 = new Car();
        swift1.setModel("Swift");
        swift1.setNumberPlate("MVZ1234");
        swift1.setType(CarType.SWIFT);
        Car swift2 = new Car();
        swift2.setModel("Swift");
        swift2.setNumberPlate("MVZ1235");
        swift2.setType(CarType.SWIFT);
        Car swift3 = new Car();
        swift3.setModel("Swift");
        swift3.setNumberPlate("MVZ1236");
        swift3.setType(CarType.SWIFT);
        Car swift4 = new Car();
        swift4.setModel("Swift");
        swift4.setNumberPlate("MVZ1238");
        swift4.setType(CarType.SWIFT);
        carSwiftList.add(swift1);
        carSwiftList.add(swift2);
        carSwiftList.add(swift3);
        carSwiftList.add(swift4);

        List<Vehicle> carI10List = new CopyOnWriteArrayList<>();
        Car i101 = new Car();
        i101.setModel("I10");
        i101.setNumberPlate("MVZ1234");
        i101.setType(CarType.I10);
        Car i102 = new Car();
        i102.setModel("I10");
        i102.setNumberPlate("MVZ1235");
        i102.setType(CarType.I10);
        Car i103 = new Car();
        i103.setModel("I10");
        i103.setNumberPlate("MVZ1236");
        i103.setType(CarType.I10);
        Car i104 = new Car();
        i104.setModel("I10");
        i104.setNumberPlate("MVZ1238");
        i104.setType(CarType.I10);
        carI10List.add(i101);
        carI10List.add(i102);
        carI10List.add(i103);
        carI10List.add(i104);

        List<Vehicle> carI20List = new CopyOnWriteArrayList<>();
        Car i201 = new Car();
        i201.setModel("I10");
        i201.setNumberPlate("MVZ1234");
        i201.setType(CarType.I20);
        Car i202 = new Car();
        i202.setModel("I10");
        i202.setNumberPlate("MVZ1235");
        i202.setType(CarType.I20);
        Car i203 = new Car();
        i203.setModel("I10");
        i203.setNumberPlate("MVZ1236");
        i203.setType(CarType.I20);
        Car i204 = new Car();
        i204.setModel("I10");
        i204.setNumberPlate("MVZ1238");
        i204.setType(CarType.I20);
        carI20List.add(i201);
        carI20List.add(i202);
        carI20List.add(i203);
        carI20List.add(i204);
        SystemAdmin.getInstance().addVehiclesToStore(VehicleType.CAR, "zoom1", carSwiftList);
        SystemAdmin.getInstance().addVehiclesToStore(VehicleType.CAR, "zoom2", carI10List);
        SystemAdmin.getInstance().addVehiclesToStore(VehicleType.CAR, "zoom3", carI20List);


    }
    public static List<Store> addStore() {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("zoom1", new Location("Ind123", new Address("Indiranagar", "80feet"))));
        stores.add(new Store("zoom2", new Location("kor123", new Address("Kormangla", "80feet"))));
        stores.add(new Store("zoom3", new Location("Ind123", new Address("HSR", "80feet"))));
        stores.add(new Store("zoom4", new Location("Ind123", new Address("JPNagar", "80feet"))));
        StoreDao.getInstance().saveStore(stores);
        return stores;
    }

    public static List<User> addUsers() {
        User john = new User("111", "John", "xyzid");
        User lisa = new User("113", "Lisa", "aabcd");
        User namy = new User("112", "Namy", "pppnp");
        User rahul = new User("117", "Rahul", "ncxkl");
        User rohan = new User("119", "Rohan", "nbvghj");
        List<User> user = new ArrayList<>();
        user.add(john);
        user.add(lisa);
        user.add(namy);
        user.add(rahul);
        user.add(rohan);
        UserDao.getInstance().saveUser(user);
        return user;
    }
    public static User getUser(String id){
        return UserDao.getInstance().getUser(id);
    }
}
