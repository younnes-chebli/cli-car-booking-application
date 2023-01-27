package com.younnescode.car;

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
}
