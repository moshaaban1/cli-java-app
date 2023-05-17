package com.cli.booking;

import com.cli.car.Car;
import com.cli.user.User;

import com.cli.car.CarService;
import com.cli.user.UserService;
import com.cli.utils.PrintListItems;
import com.cli.utils.UUIDValidator;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BookingService {
    private UserService userService;
    private BookingDAO bookingDao;
    private CarService carService;
    public BookingService() {
        this.bookingDao = new BookingDAO();
        this.carService = new CarService();
        this.userService = new UserService();
    }

    public List<Booking> getAllBookings() {
        return this.bookingDao.getAllBookings();
    }

    public void bookCar() {
        List<Car> availableCars = carService.getAllAvailableCars();
        PrintListItems.print(availableCars);

        System.out.println("➤ Select car reg number");
        Scanner scanner = new Scanner(System.in);
        String carRegNumber = scanner.nextLine();

        Car car = carService.getCarByRegNumber(carRegNumber);

        if(car == null) {
            System.out.println("✖ No car available with reg number: " + carRegNumber);
            return;
        }

        List<User> availableUsers = userService.getAllUsers();
        PrintListItems.print(availableUsers);

        System.out.println("➤ Select User ID");
        Scanner scanner2 = new Scanner(System.in);
        String userId = scanner2.nextLine();

        if(!UUIDValidator.isValidUUID(userId)) {
            System.out.println("✖ " + userId + " is not a valid ID");
            return;
        }

        User user = userService.getUserById(UUID.fromString(userId));

        if(user == null) {
            System.out.println("✖ No user found with id: " + carRegNumber);
            return;
        }

        Booking booking = new Booking(user, car);
        bookingDao.addBooking(booking);

        System.out.println(
            "Successfully booked car with reg number " +
            car.getRegNumber() + " for user " +
            user.toString()
        );
        System.out.println("Booking ref: " + booking.getBookingId());
    }

    public List<Booking> viewBookedCarsByUserId() {
        List<User> availableUsers = userService.getAllUsers();
        PrintListItems.print(availableUsers);

        System.out.println("➤ Select User ID");
        Scanner scanner = new Scanner(System.in);
        String userId = scanner.nextLine();

        if(!UUIDValidator.isValidUUID(userId)) {
            System.out.println("✖ " + userId + " is not a valid ID");
            return null;
        }

        return this.bookingDao.getAllBookingsByUserId(UUID.fromString(userId));
    }
}
