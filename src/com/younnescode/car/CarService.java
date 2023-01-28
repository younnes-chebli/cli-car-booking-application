package com.younnescode.car;

import com.younnescode.user.User;
import com.younnescode.user.UserDAO;

import java.util.Arrays;
import java.util.UUID;

public class CarService {
    private static final CarDao carDAO = new CarDao();

    private static int getAvailableCarsCpt() {
        Car[] cars = CarDao.getAllCars();
        int availableCarsCpt = 0;

        for (Car car : cars) {
            if(!car.isBooked()) {
                ++availableCarsCpt;
            }
        }

        return availableCarsCpt;
    }

    static Car[] getAvailableCars() {
        int availableCarsCpt = getAvailableCarsCpt();
        Car[] cars = CarDao.getAllCars();
        Car[] availableCars = new Car[availableCarsCpt];
        int nextAvailableIndex = 0;

        for (Car car : cars) {
            if (!car.isBooked() && nextAvailableIndex < availableCarsCpt) {
                availableCars[nextAvailableIndex++] = car;
            }
        }

        return availableCars;
    }

    static Car[] getAvailableElectricCars() {
        Car[] cars = CarDao.getAllCars();
        int electricCarsCpt = CarDao.getElectricCarsCpt();
        Car[] electricCars = new Car[electricCarsCpt];
        var nextAvailableIndex = 0;

        for (Car car : cars) {
            if(car.isElectric() && !car.isBooked() && nextAvailableIndex < electricCarsCpt) {
                electricCars[nextAvailableIndex++] = car;
            }
        }

        return electricCars;
    }

    static int getCarsCpt() {
        return CarDao.getCarsCpt();
    }

    static Car getAvailableCarByRegNumber(String regNumber) {
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
