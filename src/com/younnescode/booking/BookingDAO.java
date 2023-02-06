package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

public interface BookingDAO {
    public Booking[] getBookings();

    public Booking addBooking(User user, Car car, int i);
}
