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

    public Booking(UUID ID, User user, Car car, LocalDateTime bookingTime, boolean isCanceled) {
        this.ID = ID;
        this.user = user;
        this.car = car;
        this.bookingTime = bookingTime;
        this.isCanceled = isCanceled;
    }

    public Booking(User user, Car car) {
        this.ID = UUID.randomUUID();
        this.user = user;
        this.car = car;
        this.bookingTime = LocalDateTime.now();
        this.isCanceled = false;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return this.user;
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
