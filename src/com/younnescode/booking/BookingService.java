package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

public class BookingService {
    private static final BookingFileDataAccessService bookingFileDataAccessService = new BookingFileDataAccessService();

    Booking[] getBookings() {
        return bookingFileDataAccessService.getBookings();
    }

    Booking addBooking(User user, Car car) {
        car.setBooked(true);
        Booking[] bookings = bookingFileDataAccessService.getBookings();

        for (int i = 0; i < bookings.length; i++) {
            if(bookings[i] == null) {
                return bookingFileDataAccessService.addBooking(user, car, i);
            }
        }

        return null;
    }

    Booking[] getBookingsByUser(User user) {
        Booking[] bookings = bookingFileDataAccessService.getBookings();
        Booking[] bookingsByUser = new Booking[bookings.length];
        int nextAvailableIndex = 0;

        for (Booking booking : bookings) {
            if (booking != null && booking.getUser().equals(user) && nextAvailableIndex < bookings.length) {
                bookingsByUser[nextAvailableIndex++] = booking;
            }
        }

        return bookingsByUser;
    }
}
