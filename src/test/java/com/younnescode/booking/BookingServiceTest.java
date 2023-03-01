package com.younnescode.booking;

import com.younnescode.car.CarDAO;
import com.younnescode.car.CarDataAccessService;
import com.younnescode.car.CarService;
import com.younnescode.user.UserDAO;
import com.younnescode.user.UserDataAccessService;
import com.younnescode.user.UserService;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingServiceTest {
    UserDAO userDataAccessService = new UserDataAccessService();
    UserService userService = new UserService(userDataAccessService);
    CarDAO carDataAccessService = new CarDataAccessService();
    CarService carService = new CarService(carDataAccessService);
    BookingDAO bookingDataAccessService = new BookingDataAccessService();
    BookingService bookingService = new BookingService(bookingDataAccessService);

    @Test
    void addBooking() {
        var users = userService.getUsers();
        var user = users.get(0);
        var cars = carService.getAllCars();
        var car = cars.get(0);
        bookingService.addBooking(user, car);
        var expected = bookingService.getLastInserted();

        var result = bookingService.getBookingById(expected.getID());

        assertEquals(expected, result);
    }

    @Test
    void getBookingsByUser() {
        var users = userService.getUsers();
        var user = users.get(0);
        var bookings = bookingService.getBookings();
        var expected = bookings.stream()
                .filter(b -> b.getUser().equals(user))
                .collect(Collectors.toList());

        var result = bookingService.getBookingsByUser(user);

        assertEquals(expected, result);
    }
}
