package com.car.rental.service;

import com.car.rental.Dao.BookingServiceDao;
import com.car.rental.helper.BookingTask;
import com.car.rental.model.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {
    BookingServiceDao bookingServiceDao;
    VehicleService vehicleService;
    private static final int MAX_THREADS = 10; // Maximum number of threads to use
    private ExecutorService executor; // Executor service to manage threads
    private ReentrantLock lock;
    public BookingService() {
        this.bookingServiceDao = BookingServiceDao.getInstance();
        executor = Executors.newFixedThreadPool(MAX_THREADS);
        lock = new ReentrantLock();
    }

    public CompletableFuture<Boolean> bookVehicle(Location location, VehicleType type, User user){
        Vehicle vehicle =fetchVehicle(location,type);
        Future<String> bookingStatus=executor.submit(new BookingTask(vehicle,user));
        CompletableFuture<Boolean> future = new CompletableFuture<>();
        if(bookingStatus.isDone()){
            new Thread(()->{
                lock.lock();
                try{
                    Booking book= updateBookingStatusBooked();
                    boolean bookingSuccess=bookingServiceDao.saveBooking(user.getId(),book);
                    future.complete(bookingSuccess);
                }catch(Exception e){
                    future.completeExceptionally(e);
                }finally{
                    lock.unlock();
                }
            }).start();
        }
      return future;
    }

    private Booking updateBookingStatusBooked() {
        Booking book = new Booking();
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStart(System.currentTimeMillis());
        timeSlot.setEnd(System.currentTimeMillis()+100);
        book.setTime(timeSlot);
        Random random= new Random();
        book.setBookingId(random.nextInt());
        book.setBookingStatus(BookingStatus.BOOKED);
        return book;

    }

    private Vehicle fetchVehicle(Location location, VehicleType type){
         this.vehicleService =  VehicleServiceFactory.createVehicle(type);
        return vehicleService.getVehicleDetails(location);
    }
}
