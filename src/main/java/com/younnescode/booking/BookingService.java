package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingService {
    private final BookingDAO bookingDataAccessService;

    public BookingService(BookingDAO bookingFileDataAccessService) {
        this.bookingDataAccessService = bookingFileDataAccessService;
    }

    public List<Booking> getBookings() {
        return bookingDataAccessService.getBookings();
    }

    public void addBooking(User user, Car car) {
        car.setBooked(true);
        bookingDataAccessService.addBooking(user, car);
    }

    public List<Booking> getBookingsByUser(User user) {
        var bookings = bookingDataAccessService.getBookings();

        var bookingsByUser = bookings.stream()
                .filter(b -> b.getUser().equals(user))
                .collect(Collectors.toList());

        return bookingsByUser;
    }

    public Booking getBookingById(UUID bookingId) {
        var bookings = bookingDataAccessService.getBookings();

        for (var booking : bookings) {
            if(booking.getID().equals(bookingId)) {
                return booking;
            }
        }

        return null;
    }

    public Booking getLastInserted() {
        return bookingDataAccessService.getLastInserted();
    }
}
