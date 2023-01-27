package com.younnescode.car;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CarService {
    private static final CarDao carDAO = new CarDao();

    Car[] getAvailableCars() {
        return carDAO.getAvailableCars();
    }

    Car[] getAvailableElectricCars() {
        return carDAO.getAvailableElectricCars();
    }

    static int getCarsCpt() {
        return CarDao.getCarsCpt();
    }

    private static String[] getAvailableCarsRegNumbers() {
        return CarDao.getAvailableCarsRegNumbers();
    }

    static boolean match(String regNumber) {
        String[] availableCarsRegNumbers = getAvailableCarsRegNumbers();
        return Arrays.asList(availableCarsRegNumbers).contains(regNumber);
    }
}
