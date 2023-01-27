package com.younnescode.app;

import com.younnescode.booking.Booking;
import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class CarBookingAppUtils {
    static Scanner scan = new Scanner(System.in);

    private static void notValidOption() {
        System.out.println("⛔ Not a valid option\n");
        showMenu();
    }

    private static void noBookingsAvailable() {
        System.out.println("⛔ No Bookings Available\n");
        showMenu();
    }

    private static void noCarsBooked(User user) {
        System.out.println("⛔ " + user + " has no car Booked");
        showMenu();
    }

    private static void noMatchingAvailableCar() {
        System.out.println("⛔ Not a valid option\n");
        System.out.println();
        bookCar();
    }

    private static void showUsers() {
        User[] users = User.getUsers();

        for (User user : users) {
            System.out.println("\uD83D\uDE09 " + user);
        }
    }

    private static void showAvailableCars() {
        Car[] availableCars = Car.getAvailableCars();

        for (Car availableCar : availableCars) {
            System.out.println("\uD83D\uDE97 " + availableCar);
        }
    }

    private static void showAvailableElectricCars() {
        Car[] electricCars = Car.getAvailableElectricCars();

        for (Car electricCar : electricCars) {
            System.out.println("\uD83D\uDE97 " + electricCar);
        }
    }

    private static String askForUserId() {
        System.out.print("\uD83D\uDD0D Select User ID: ");
        String userId = scan.nextLine();
        return userId;
    }

    private static String askForRegNumber() {
        System.out.print("\uD83D\uDD0D Select Car REG NUMBER: ");
        String regNumber = scan.nextLine();
        return regNumber;
    }

    private static void bookCar() {
        showAvailableCars();
        System.out.println();
        String regNumber = askForRegNumber();
        System.out.println();
            if(Car.match(regNumber)) {
                showUsers();
                System.out.println();
                String userId = askForUserId();
                System.out.println();
                if(true) {
                    //book car
                    //success
                }
            } else {
                noMatchingAvailableCar();
            }
    }

    private static void viewAllUsersBookedCars() {
        showUsers();
        System.out.println();
        String userId = askForUserId();
        //get booked cars by user
    }

    private static void viewAllBookings() {
        Booking[] bookings = Booking.getBookings();
        if(Arrays.stream(bookings).allMatch(Objects::isNull)) {
            noBookingsAvailable();
        } else {
            for (Booking booking : bookings) {
                System.out.println("\uD83D\uDD11 " + booking);
            }
        }
        System.out.println();
        showMenu();
    }

    private static void viewAvailableCars() {
        showAvailableCars();
        System.out.println();
        showMenu();
    }

    private static void viewAvailableElectricCars() {
        showAvailableElectricCars();
        System.out.println();
        showMenu();
    }

    private static void viewAllUsers() {
        showUsers();
        System.out.println();
        showMenu();
    }

    private static void exit() {
        System.out.println("\uD83D\uDC4B Bye Bye \uD83D\uDE04");
        System.exit(0);
    }

    static void showMenu() {
        System.out.println (
                "1. Book Car\n" +
                "2. View All Users Booked Cars\n" +
                "3. View All Bookings\n" +
                "4. View Available Cars\n" +
                "5. View Available Electric Cars\n" +
                "6. View All Users\n" +
                "7. Exit\n"
        );
        String option = scan.nextLine();
        switch (option) {
            case "1":
                bookCar();
                break;
            case "2":
                viewAllUsersBookedCars();
                break;
            case "3":
                viewAllBookings();
                break;
            case "4":
                viewAvailableCars();
                break;
            case "5":
                viewAvailableElectricCars();
                break;
            case "6":
                viewAllUsers();
                break;
            case "7":
                exit();
                break;
            default:
                notValidOption();
        }
    }
}
