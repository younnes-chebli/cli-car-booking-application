package com.younnescode.car;

import java.util.UUID;

public class CarService {
    private final CarFileDataAccessService carFileDataAccessService;

    public CarService(CarFileDataAccessService carFileDataAccessService) {
        this.carFileDataAccessService = carFileDataAccessService;
    }

    private boolean isAvailable(Car car) {
        return !car.isBooked();
    }

    private boolean isAvailableElectric(Car car) {
        return !car.isBooked() && car.isElectric();
    }

    public Car[] getAvailableCars() {
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

    public Car[] getAvailableElectricCars() {
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

    public Car getAvailableCarByRegNumber(String regNumber) {
        Car[] availableCars = getAvailableCars();
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

    public void update(Car updatedCar) {
        carFileDataAccessService.update(updatedCar);
    }
}
