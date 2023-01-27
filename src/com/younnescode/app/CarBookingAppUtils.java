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
        System.out.println("Not a valid option\n");
        showMenu();
    }

    private static void noBookingsAvailable() {
        System.out.println("No Bookings Available\n");
        showMenu();
    }

    private static void noCarsBooked(User user) {
        System.out.println(user + " has no car Booked");
        showMenu();
    }

    private static void showUsers() {
        User[] users = User.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void showAvailableCars() {
        Car[] availableCars = Car.getAvailableCars();

        for (Car availableCar : availableCars) {
            System.out.println(availableCar);
        }
    }

    private static String askForUserId() {
        System.out.print("Select User ID: ");
        String userId = scan.nextLine();
        return userId;
    }

    private static String askForRegNumber() {
        System.out.print("Select Car Reg Number: ");
        String regNumber = scan.nextLine();
        return regNumber;
    }

    private static void bookCar() {
        showAvailableCars();
        System.out.println();
        String regNumber = askForRegNumber();
        showUsers();
        System.out.println();
        String userId = askForUserId();
        //book car
        //success
    }

    private static void viewAllUsersBookedCars() {
        showUsers();
        System.out.println();
        String userId = askForUserId();
        //get booked cars by user
    }

    private static void viewAllBookings() {
        Booking[] bookings = Booking.getBookings();
        if(false) {
            noBookingsAvailable();
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
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
        Car[] electricCars = Car.getAvailableElectricCars();

        for (Car electricCar : electricCars) {
            System.out.println(electricCar);
        }
        System.out.println();
        showMenu();
    }

    private static void viewAllUsers() {
        showUsers();
        System.out.println();
        showMenu();
    }

    private static void exit() {

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
