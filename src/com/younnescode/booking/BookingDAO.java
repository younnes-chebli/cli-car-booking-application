package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

public interface BookingDAO {
    Booking[] getBookings();

//    Booking addBooking(User user, Car car, int i);
    Booking addBooking(User user, Car car);
}
