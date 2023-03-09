package com.car.rental.Dao;

import com.car.rental.exception.StoreNotFoundException;
import com.car.rental.model.Address;
import com.car.rental.model.Location;
import com.car.rental.model.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreDao {
    Map<String, Store> storeMap;
    private static StoreDao storeDao=null;
    private StoreDao(){
        this.storeMap = new HashMap<>();

    }
    public static StoreDao getInstance(){
        if(storeDao==null){
            return new StoreDao();
        }
        return storeDao;
    }
    public void saveStore(List<Store> stores){
       for(Store store:stores){
           storeMap.putIfAbsent(store.getLocation().getId(),store);
       }

    }
    public Store getStoreDetails(String locationId) throws StoreNotFoundException {
        if(!storeMap.containsKey(locationId)){
            throw new StoreNotFoundException("we do not have any store in this location");
        }
        return storeMap.get(locationId);
    }
}
