package com.cli.booking;

import com.cli.car.Car;
import com.cli.user.User;

import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private User user;
    private Car car;

    public Booking(User user, Car car) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.car = car;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public UUID getUserId() {
        return user.getId();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}
