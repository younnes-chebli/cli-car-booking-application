package com.younnescode.app;

import com.younnescode.car.Car;
import com.younnescode.user.User;

import java.util.Scanner;

class CarBookingAppUtils {
    static Scanner scan = new Scanner(System.in);

    private static void notValidOption() {
        System.out.println("Not a valid option\n");
        showMenu();
    }

    private static void bookCar() {

    }

    private static void viewAllUsersBookedCars() {

    }

    private static void viewAllBookings() {

    }

    private static void viewAvailableCars() {
        Car[] availableCars = Car.getCars();

        for (Car availableCar : availableCars) {
            System.out.println(availableCar);
        }
        System.out.println();
        showMenu();
    }

    private static void viewAvailableElectricCars() {
        Car[] electricCars = Car.getElectricCars();

        for (Car electricCar : electricCars) {
            System.out.println(electricCar);
        }
        System.out.println();
        showMenu();
    }

    private static void viewAllUsers() {
        User[] users = User.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
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
