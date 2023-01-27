package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.car.CarDao;

public class BookingDAO {
    private static final Booking[] bookings;

    static {
        bookings = new Booking[Car.getCarsCpt()];
    }

    static Booking[] getBookings() {
        return bookings;
    }
}
