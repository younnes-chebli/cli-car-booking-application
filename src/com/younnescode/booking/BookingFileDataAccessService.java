package com.younnescode.booking;

import com.younnescode.car.Brand;
import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class BookingFileDataAccessService implements BookingDAO {

    private static final File bookingsFile = new File("src/com/younnescode/files/bookings.csv");

    private int getBookingsCount() {
        int count = 0;

        try {
            Scanner scanner = new Scanner(bookingsFile);

            scanner.nextLine();
            while(scanner.hasNext()) {
                ++count;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    @Override
    public Booking[] getBookings() {
        int bookingsCounts = getBookingsCount();
        Booking[] bookings = new Booking[bookingsCounts];
        int nextAvailableIndex = 0;

        if(bookingsCounts > 0) {
            try {
                Scanner scanner = new Scanner(bookingsFile);

                scanner.nextLine();
                while(scanner.hasNext() && nextAvailableIndex < bookings.length) {
                    String fileLine = scanner.nextLine();
                    String[] bookingFromFile = fileLine.split(",");
                    int nextLineIndex = 0;

                    try {
                        bookings[nextAvailableIndex++] = new Booking(
                            UUID.fromString(bookingFromFile[nextLineIndex++].trim()),
                            new User(
                                    UUID.fromString(bookingFromFile[nextLineIndex++].trim()),
                                    bookingFromFile[nextLineIndex++].trim()
                            ),
                            new Car(
                                    UUID.fromString(bookingFromFile[nextLineIndex++].trim()),
                                    new BigDecimal(bookingFromFile[nextLineIndex++].trim()).setScale(2, BigDecimal.ROUND_HALF_EVEN),
                                    Brand.valueOf(bookingFromFile[nextLineIndex++].trim()),
                                    Boolean.parseBoolean(bookingFromFile[nextLineIndex++].trim()),
                                    Boolean.parseBoolean(bookingFromFile[nextLineIndex++].trim())
                            ),
                            LocalDateTime.parse(bookingFromFile[nextLineIndex++].trim()),
                            Boolean.parseBoolean(bookingFromFile[nextLineIndex++].trim())
                        );
                    } catch(IllegalArgumentException e) {
                        e.getMessage();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return bookings;
    }

    @Override
    public Booking addBooking(User user, Car car, int i) {
        return null;
    }
}
