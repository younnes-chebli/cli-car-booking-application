package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.time.LocalDateTime;
import java.util.Objects;
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

    public UUID getID() {
        return ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isCanceled == booking.isCanceled && Objects.equals(ID, booking.ID) && Objects.equals(user, booking.user) && Objects.equals(car, booking.car) && Objects.equals(bookingTime, booking.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, user, car, bookingTime, isCanceled);
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
