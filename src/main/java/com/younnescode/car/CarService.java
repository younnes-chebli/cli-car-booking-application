package com.younnescode.car;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CarService {
    private final CarDAO carDataAccessService;

    public CarService(CarDAO carFileDataAccessService) {
        this.carDataAccessService = carFileDataAccessService;
    }

    public List<Car> getAllCars() {
        return carDataAccessService.getCars();
    }

    public List<Car> getAvailableCars() {
        var cars = carDataAccessService.getCars();

        var availableCars = cars.stream()
                .filter(c -> !c.isBooked())
                .collect(Collectors.toList());

        return availableCars;
    }

    public List<Car> getAvailableElectricCars() {
        var cars = carDataAccessService.getCars();

        var electricCars = cars.stream()
                .filter(c -> !c.isBooked() && c.isElectric())
                .collect(Collectors.toList());

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
}
