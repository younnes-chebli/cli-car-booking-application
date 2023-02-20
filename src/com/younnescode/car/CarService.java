package com.younnescode.car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarService {
    private final CarDAO carDataAccessService;

    public CarService(CarDAO carFileDataAccessService) {
        this.carDataAccessService = carFileDataAccessService;
    }

    private boolean isAvailable(Car car) {
        return !car.isBooked();
    }

    private boolean isAvailableElectric(Car car) {
        return !car.isBooked() && car.isElectric();
    }

    public List<Car> getAvailableCars() {
        var cars = carDataAccessService.getCars();
        var availableCars = new ArrayList<Car>();

        cars.forEach(e -> {
            if(isAvailable(e)) {
                availableCars.add(e);
            }
        });

        return availableCars;
    }

    public List<Car> getAvailableElectricCars() {
        var cars = carDataAccessService.getCars();
        var electricCars = new ArrayList<Car>();

        cars.forEach(e -> {
            if(isAvailableElectric(e)) {
                electricCars.add(e);
            }
        });

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
            if(availableCar.getREG_NUMBER().equals(ID)) {
                return availableCar;
            }
        }

        return null;
    }

    public void update(Car updatedCar) {
        carDataAccessService.update(updatedCar);
    }
}
