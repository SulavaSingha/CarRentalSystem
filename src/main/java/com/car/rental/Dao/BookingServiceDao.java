package com.car.rental.Dao;

import com.car.rental.model.Booking;
import com.car.rental.model.User;
import com.car.rental.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingServiceDao {
    Map<String, Vehicle> bookingMap;
    Map<String, Booking> bookingDetails;
    private static BookingServiceDao bookingServiceDao = null;

    private BookingServiceDao() {
        this.bookingMap = new ConcurrentHashMap<>();
        this.bookingDetails = new ConcurrentHashMap<>();
    }


    public static BookingServiceDao getInstance() {
        if(bookingServiceDao==null)
            return new BookingServiceDao();
        return  bookingServiceDao;
    }

    public boolean book(Vehicle vehicle, User user) {
        if (bookingMap.containsKey(user.getDrivingLicense())) {
            return false;
        }
        bookingMap.put(user.getDrivingLicense(), vehicle);
        return true;
    }

    public boolean saveBooking(String id, Booking book) {
        bookingDetails.put(id, book);
        return true;
    }
}
