package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.awt.print.Book;

public class BookingService {
    private static final BookingFileDataAccessService bookingFileDataAccessService = new BookingFileDataAccessService();

    Booking[] getBookings() {
        return bookingFileDataAccessService.getBookings();
    }

    Booking addBooking(User user, Car car) {
        car.setBooked(true);
        car.update();

        return bookingFileDataAccessService.addBooking(user, car);
    }

    Booking[] getBookingsByUser(User user) {
        Booking[] bookings = bookingFileDataAccessService.getBookings();
        Booking[] bookingsByUser = new Booking[bookings.length];
        int nextAvailableIndex = 0;

        for (Booking booking : bookings) {
            if (booking != null && booking.getUser().equals(user)) {
                bookingsByUser[nextAvailableIndex++] = booking;
            }
        }

        return bookingsByUser;
    }
}
