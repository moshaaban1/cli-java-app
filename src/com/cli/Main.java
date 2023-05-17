package com.cli;

import com.cli.booking.BookingService;
import com.cli.car.CarService;
import com.cli.user.UserService;
import com.cli.utils.PrintListItems;

import java.util.Scanner;

public class Main {
    private static BookingService bookingService = new BookingService();
    private static CarService carService = new CarService();
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        while(true) {
            getUserInputChoice();
        }
    }

    private static void getUserInputChoice() {
        System.out.println(
                "\n1 - Book Car\n" +
                        "2 - View All User Booked Cars\n" +
                        "3 - View All Bookings\n" +
                        "4 - View Available Cars\n" +
                        "5 - View Available Electric Cars\n" +
                        "6 - View All Users\n" +
                        "7 - Exit\n"
        );

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        try {
            int userInputInt = Integer.parseInt(userInput);

            if(userInputInt < 1 || userInputInt > 7) throw new NumberFormatException();

            cliFunctions(userInputInt);

        } catch (NumberFormatException e) {
            System.out.println(userInput + " is not a valid option \uD83D\uDC4E");
        }
    }

    private static void cliFunctions(int userInput) {
        switch (userInput) {
            case 1 -> bookingService.bookCar();
            case 2 -> PrintListItems.print(bookingService.viewBookedCarsByUserId());
            case 3 -> PrintListItems.print(bookingService.getAllBookings());
            case 4 -> PrintListItems.print(carService.getAllAvailableCars());
            case 5 -> PrintListItems.print(carService.getAllAvailableElectricCars());
            case 6 -> PrintListItems.print(userService.getAllUsers());
            case 7 -> System.exit(0);
        }
    }

    private static void viewAllUserBookedCars() {

    }
}