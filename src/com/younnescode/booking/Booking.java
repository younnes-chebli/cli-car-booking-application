package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private final UUID ID;
    private User user;
    private Car car;
    private LocalDateTime bookingTime;
    private boolean isCanceled;

    private static final BookingService bookingService = new BookingService();

    {
        this.ID = UUID.randomUUID();
        this.bookingTime = LocalDateTime.now();
        this.isCanceled = false;
    }

    public Booking(User user, Car car) {
        this.user = user;
        this.car = car;
    }

    public static Booking[] getBookings() {
        return bookingService.getBookings();
    }

    public static Booking addBooking(User user, Car car) {
        return bookingService.addBooking(user, car);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + ID +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceled=" + isCanceled +
                '}';
    }
}
