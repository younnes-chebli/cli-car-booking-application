package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.car.CarService;
import com.younnescode.user.User;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final BookingDAO bookingDataAccessService;
    private final CarService carService;

    public BookingService(BookingDAO bookingFileDataAccessService, CarService carService) {
        this.bookingDataAccessService = bookingFileDataAccessService;
        this.carService = carService;
    }

    public List<Booking> getBookings() {
        return bookingDataAccessService.getBookings();
    }

    public void addBooking(User user, Car car) {
        car.setBooked(true);
        carService.update(car);

        bookingDataAccessService.addBooking(user, car);
    }

    public List<Booking> getBookingsByUser(User user) {
        var bookings = bookingDataAccessService.getBookings();
        var bookingsByUser = new ArrayList<Booking>();

        for (var booking : bookings) {
            if (booking != null && booking.getUser().equals(user)) {
                bookingsByUser.add(booking);
            }
        }

        return bookingsByUser;
    }

    public Booking getLastInserted() {
        return bookingDataAccessService.getLastInserted();
    }
}
