package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.car.CarService;
import com.younnescode.user.User;

public class BookingService {
    private final BookingFileDataAccessService bookingFileDataAccessService;
    private final CarService carService;

    public BookingService(BookingFileDataAccessService bookingFileDataAccessService, CarService carService) {
        this.bookingFileDataAccessService = bookingFileDataAccessService;
        this.carService = carService;
    }

    public Booking[] getBookings() {
        return bookingFileDataAccessService.getBookings();
    }

    public Booking addBooking(User user, Car car) {
        car.setBooked(true);
        carService.update(car);

        return bookingFileDataAccessService.addBooking(user, car);
    }

    public Booking[] getBookingsByUser(User user) {
        var bookings = bookingFileDataAccessService.getBookings();
        var bookingsByUser = new Booking[bookings.length];
        int nextAvailableIndex = 0;

        for (var booking : bookings) {
            if (booking != null && booking.getUser().equals(user)) {
                bookingsByUser[nextAvailableIndex++] = booking;
            }
        }

        return bookingsByUser;
    }
}
