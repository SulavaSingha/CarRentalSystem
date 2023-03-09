package com.car.rental.helper;

import com.car.rental.Dao.BookingServiceDao;
import com.car.rental.model.Booking;
import com.car.rental.model.BookingStatus;
import com.car.rental.model.User;
import com.car.rental.model.Vehicle;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class BookingTask implements Callable {
    private  Vehicle vehicle;
    private User user;
    private final BookingServiceDao bookingServiceDao=BookingServiceDao.getInstance();
    public BookingTask(Vehicle vehicle, User user){
        this.vehicle=vehicle;
        this.user=user;
    }


    @Override
    public String call() throws Exception {
        String result=null;
        if(bookingServiceDao.book(vehicle,user)){
            result= BookingStatus.BOOKED.toString();
        }
        else {
            result ="Booking cannot be done";
        }
        return result;
    }
}
