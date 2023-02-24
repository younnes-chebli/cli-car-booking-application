package com.younnescode.booking;

import com.younnescode.car.Car;
import com.younnescode.car.CarService;
import com.younnescode.user.User;

import java.util.List;
import java.util.stream.Collectors;

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

        var bookingsByUser = bookings.stream()
                .filter(b -> b.getUser().equals(user))
                .collect(Collectors.toList());

        return bookingsByUser;
    }

    public Booking getLastInserted() {
        return bookingDataAccessService.getLastInserted();
    }
}
