package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

public class BookingArrayDataAccessService implements BookingDAO {
    private static final Booking[] bookings;

    static {
        bookings = new Booking[3];
    }

    @Override
    public Booking[] getBookings() {
        return bookings;
    }

    @Override
    public Booking addBooking(User user, Car car) {
        return null;
    }
}