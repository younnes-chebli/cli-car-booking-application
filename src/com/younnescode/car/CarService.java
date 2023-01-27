package com.younnescode.car;

public class CarService {
    private static final CarDao carDAO = new CarDao();

    Car[] getCars() {
        return carDAO.getCars();
    }

    Car[] getElectricCars() {
        return carDAO.getElectricCars();
    }
}
