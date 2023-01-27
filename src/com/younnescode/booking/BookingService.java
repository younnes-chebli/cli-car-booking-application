package com.younnescode.booking;

public class BookingService {
    private static final BookingDAO bookingDAO = new BookingDAO();

    static Booking[] getBookings() {
        return BookingDAO.getBookings();
    }
}
