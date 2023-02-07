package com.younnescode.car;

import java.util.UUID;

public class CarService {
    private static final CarFileDataAccessService carFileDataAccessService = new CarFileDataAccessService();

    int getCarsCpt() {
        int carsCpt = 0;

        Car[] cars = carFileDataAccessService.getCars();

        for (Car car : cars) {
            if (car != null) {
                carsCpt++;
            }
        }

        return carsCpt;
    }

    private boolean isAvailable(Car car) {
        return !car.isBooked();
    }

    private boolean isAvailableElectric(Car car) {
        return !car.isBooked() && car.isElectric();
    }

    Car[] getAvailableCars() {
        Car[] cars = carFileDataAccessService.getCars();
        Car[] availableCars = new Car[cars.length];
        int nextAvailableIndex = 0;

        for (Car car : cars) {
            if (car != null && isAvailable(car)) {
                availableCars[nextAvailableIndex++] = car;
            }
        }

        return availableCars;
    }

    Car[] getAvailableElectricCars() {
        Car[] cars = carFileDataAccessService.getCars();
        Car[] electricCars = new Car[cars.length];
        var nextAvailableIndex = 0;

        for (Car car : cars) {
            if(car != null && isAvailableElectric(car)) {
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

    void update(Car updatedCar) {
        carFileDataAccessService.update(updatedCar);
    }
}
