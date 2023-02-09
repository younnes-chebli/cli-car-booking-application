package com.younnescode.app;

import com.younnescode.booking.Booking;
import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CarBookingApp {
    static Scanner scan = new Scanner(System.in);

    private static boolean isEmpty(Object[] object) {
        return Arrays.stream(object).allMatch(Objects::isNull);
    }

    private static void notValidOption() {
        System.out.println("⛔ Not a valid option\n");
        System.out.println();
        showMenu();
    }

    private static void noAvailableCars() {
        System.out.println("❌ No Available Cars\n");
        System.out.println();
        showMenu();
    }

    private static void noAvailableElectricCars() {
        System.out.println("❌ No Available Electric Cars\n");
        System.out.println();
        showMenu();
    }

    private static void noBookingsAvailable() {
        System.out.println("❌ No Bookings Available\n");
        System.out.println();
        showMenu();
    }

    private static void noCarsBooked() {
        System.out.println("❌ This user has no cars Booked");
        System.out.println();
        showMenu();
    }

    private static void noMatchingBook() {
        System.out.println("⛔ Not a valid option\n");
        System.out.println();
        bookCar();
    }

    private static void noMatchingViewBookings() {
        System.out.println("⛔ Not a valid option\n");
        System.out.println();
        viewAllUsersBookedCars();
    }

    private static void success(Booking booking) {
        System.out.println("\uD83D\uDD11 You Successfully Booked A Car! \uD83C\uDF89 \uD83C\uDF89 \uD83C\uDF89\n");
        System.out.println("\uD83D\uDD11 " + booking);
        System.out.println();
        showMenu();
    }

    private static void showUsers() {
        User[] users = User.getUsers();

        for (User user : users) {
            if(user != null) {
                System.out.println("\uD83D\uDE09 " + user);
            }
        }
    }

    private static void showAvailableCars() {
        Car[] availableCars = Car.getAvailableCars();

        if(!isEmpty(availableCars)) {
            for (Car availableCar : availableCars) {
                if(availableCar != null) {
                    System.out.println("\uD83D\uDE97 " + availableCar);
                }
            }
        } else {
            noAvailableCars();
        }
    }

    private static void showAvailableElectricCars() {
        Car[] availableElectricCars = Car.getAvailableElectricCars();

        if(!isEmpty(availableElectricCars)) {
            for (Car availableElectricCar : availableElectricCars) {
                if(availableElectricCar != null) {
                    System.out.println("\uD83D\uDE97 " + availableElectricCar);
                }
            }
        } else {
            noAvailableElectricCars();
        }
    }

    private static void showBookings(Booking[] bookings) {
        for (Booking booking : bookings) {
            if(booking != null) {
                System.out.println("\uD83D\uDD11 " + booking);
            }
        }
        System.out.println();
        showMenu();
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
        if(Car.getAvailableCarByRegNumber(regNumber) != null) {
            showUsers();
            System.out.println();
            String userId = askForUserId();
            System.out.println();
            if(User.getUserById(userId) != null) {
                User user = User.getUserById(userId);
                Car car = Car.getAvailableCarByRegNumber(regNumber);
                Booking booking = Booking.addBooking(user, car);
                success(booking);
            } else {
                noMatchingBook();
            }
        } else {
            noMatchingBook();
        }
    }

    private static void viewAllUsersBookedCars() {
        showUsers();
        System.out.println();
        String userId = askForUserId();
        if(User.getUserById(userId) != null) {
            User user = User.getUserById(userId);
            Booking[] bookingsByUser = Booking.getBookingsByUser(user);
            if(!isEmpty(bookingsByUser)) {
                showBookings(bookingsByUser);
            } else {
                noCarsBooked();
            }
        } else {
            noMatchingViewBookings();
        }
    }

    private static void viewAllBookings() {
        Booking[] bookings = Booking.getBookings();
        if(isEmpty(bookings)) {
            noBookingsAvailable();
        } else {
            showBookings(bookings);
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
                "\uD83E\uDD35 \n" +
                        "1️⃣ Book Car\n" +
                        "2️⃣ View All Users Booked Cars\n" +
                        "3️⃣ View All Bookings\n" +
                        "4️⃣ View Available Cars\n" +
                        "5️⃣ View Available Electric Cars\n" +
                        "6️⃣ View All Users\n" +
                        "7️⃣ Exit\n"
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

    public static void main(String[] args) {
            showMenu();
        }
    }
