package com.younnescode.car;

import java.util.UUID;

public class CarService {
    private static final CarDao carDAO = new CarDao();

    int getCarsCpt() {
        return carDAO.getCarsCpt();
    }

    private boolean isAvailable(Car car) {
        return !car.isBooked();
    }

    private boolean isAvailableElectric(Car car) {
        return !car.isBooked() && car.isElectric();
    }

    private int getAvailableCarsCpt() {
        Car[] cars = carDAO.getAllCars();
        int availableCarsCpt = 0;

        for (Car car : cars) {
            if(isAvailable(car)) {
                ++availableCarsCpt;
            }
        }

        return availableCarsCpt;
    }

    Car[] getAvailableCars() {
        int availableCarsCpt = getAvailableCarsCpt();
        Car[] cars = carDAO.getAllCars();
        Car[] availableCars = new Car[availableCarsCpt];
        int nextAvailableIndex = 0;

        for (Car car : cars) {
            if (isAvailable(car) && nextAvailableIndex < availableCarsCpt) {
                availableCars[nextAvailableIndex++] = car;
            }
        }

        return availableCars;
    }

    private int getAvailableElectricCarsCpt() {
        Car[] cars = carDAO.getAllCars();
        int availableElectricCarsCpt = 0;

        for (Car car : cars) {
            if(isAvailableElectric(car)) {
                ++availableElectricCarsCpt;
            }
        }

        return availableElectricCarsCpt;
    }

    Car[] getAvailableElectricCars() {
        int availableElectricCarsCpt = getAvailableElectricCarsCpt();
        Car[] cars = carDAO.getAllCars();
        Car[] electricCars = new Car[availableElectricCarsCpt];
        var nextAvailableIndex = 0;

        for (Car car : cars) {
            if(isAvailableElectric(car) && nextAvailableIndex < availableElectricCarsCpt) {
                electricCars[nextAvailableIndex++] = car;
            }
        }

        return electricCars;
    }

    Car getAvailableCarByRegNumber(String regNumber) {
        Car[] availableCars = Car.getAvailableCars();
        UUID ID = null;

        try{
            ID = UUID.fromString(regNumber);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        for (Car availableCar : availableCars) {
            if(availableCar.getREG_NUMBER().equals(ID)) {
                return availableCar;
            }
        }

        return null;
    }
}
