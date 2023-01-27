package com.younnescode.car;

import java.util.Arrays;

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

    private static String[] getAvailableCarsRegNumbers() {
        Car[] availableCars = getAvailableCars();
        int availableCarsCapacity = getAvailableCars().length;
        String[] availableCarsRegNumbers = new String[availableCarsCapacity];
        int nextAvailableIndex = 0;

        for (Car availableCar : availableCars) {
            if(nextAvailableIndex < availableCarsCapacity) {
                availableCarsRegNumbers[nextAvailableIndex++] = availableCar.getREG_NUMBER().toString();
            }
        }

        return availableCarsRegNumbers;
    }

    static boolean match(String regNumber) {
        String[] availableCarsRegNumbers = getAvailableCarsRegNumbers();
        return Arrays.asList(availableCarsRegNumbers).contains(regNumber);
    }
}
