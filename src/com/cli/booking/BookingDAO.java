package com.cli.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingDAO {
    private static List<Booking> bookingsList = new ArrayList<>();

    public List<Booking> getAllBookings() {
        return bookingsList;
    }

    public void addBooking(Booking booking) {
        bookingsList.add(booking);
    }

    public List<Booking> getAllBookingsByUserId(UUID userId) {
        return bookingsList.stream().filter(booking -> booking.getUserId().equals(userId)).toList();
    }
}
