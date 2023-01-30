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

    Car[] getAvailableCars() {
        Car[] cars = carDAO.getAllCars();
        Car[] availableCars = new Car[cars.length];
        int nextAvailableIndex = 0;

        for (Car car : cars) {
            if (isAvailable(car) && nextAvailableIndex < cars.length) {
                availableCars[nextAvailableIndex++] = car;
            }
        }

        return availableCars;
    }

    Car[] getAvailableElectricCars() {
        Car[] cars = carDAO.getAllCars();
        Car[] electricCars = new Car[cars.length];
        var nextAvailableIndex = 0;

        for (Car car : cars) {
            if(isAvailableElectric(car) && nextAvailableIndex < cars.length) {
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
            if(availableCar != null && availableCar.getREG_NUMBER().equals(ID)) {
                return availableCar;
            }
        }

        return null;
    }
}
