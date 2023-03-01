package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.util.List;

public interface BookingDAO {
    List<Booking> getBookings();

    void addBooking(User user, Car car);

    Booking getBookingById();

    Booking getLastInserted();
}
