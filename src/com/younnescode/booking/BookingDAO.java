package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

public class BookingDAO {
    private static final Booking[] bookings;

    static {
        bookings = new Booking[Car.getCarsCpt()];
    }

    Booking[] getBookings() {
        return bookings;
    }

    Booking addBooking(User user, Car car, int i) {
        return bookings[i] = new Booking(user, car);
    }
}
