package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class Booking {
    private UUID id;
    private User user;
    private Car car;
    private LocalDateTime bookingTime;
    private boolean isCanceled;

    private static final BookingService bookingService = new BookingService();

    {
        this.id = UUID.randomUUID();
        this.bookingTime = LocalDateTime.now();
        this.isCanceled = false;
    }

    public Booking(User user, Car car) {
        this.user = user;
        this.car = car;
    }

    public static Booking[] getBookings() {
        return BookingService.getBookings();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceled=" + isCanceled +
                '}';
    }
}
