package com.younnescode.car;

import java.util.UUID;

public class CarService {
    private final CarDAO carFileDataAccessService;

    public CarService(CarDAO carFileDataAccessService) {
        this.carFileDataAccessService = carFileDataAccessService;
    }

    private boolean isAvailable(Car car) {
        return !car.isBooked();
    }

    private boolean isAvailableElectric(Car car) {
        return !car.isBooked() && car.isElectric();
    }

    public Car[] getAvailableCars() {
        var cars = carFileDataAccessService.getCars();
        var availableCars = new Car[cars.length];
        var nextAvailableIndex = 0;

        for (var car : cars) {
            if (car != null && isAvailable(car)) {
                availableCars[nextAvailableIndex++] = car;
            }
        }

        return availableCars;
    }

    public Car[] getAvailableElectricCars() {
        var cars = carFileDataAccessService.getCars();
        var electricCars = new Car[cars.length];
        var nextAvailableIndex = 0;

        for (var car : cars) {
            if(car != null && isAvailableElectric(car)) {
                electricCars[nextAvailableIndex++] = car;
            }
        }

        return electricCars;
    }

    public Car getAvailableCarByRegNumber(String regNumber) {
        var availableCars = getAvailableCars();
        UUID ID = null;

        try{
            ID = UUID.fromString(regNumber);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        for (var availableCar : availableCars) {
            if(availableCar != null && availableCar.getREG_NUMBER().equals(ID)) {
                return availableCar;
            }
        }

        return null;
    }

    public void update(Car updatedCar) {
        carFileDataAccessService.update(updatedCar);
    }
}
