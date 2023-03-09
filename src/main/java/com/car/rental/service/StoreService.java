package com.car.rental.service;

import com.car.rental.Dao.StoreDao;
import com.car.rental.exception.StoreNotFoundException;
import com.car.rental.model.Store;

public class StoreService {
    private final StoreDao storeDao =StoreDao.getInstance();
    public Store getStoreDetails(String locationId) throws StoreNotFoundException {
        return storeDao.getStoreDetails(locationId);
    }

}

