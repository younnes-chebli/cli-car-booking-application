package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.util.ArrayList;
import java.util.List;

public class BookingDataAccessService implements BookingDAO {
    private static final List<Booking> bookings;

    static {
        bookings = new ArrayList<>();
    }

    @Override
    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public void addBooking(User user, Car car) {
        bookings.add(new Booking(user, car));
    }

    @Override
    public Booking getBookingById() {
        return null;
    }

    @Override
    public Booking getLastInserted() {
        return bookings.get(bookings.size() - 1);
    }
}