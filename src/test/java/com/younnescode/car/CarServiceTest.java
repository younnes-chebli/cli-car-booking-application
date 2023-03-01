package com.younnescode.car;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {
    CarDAO carDataAccessService = new CarDataAccessService();
    CarService carService = new CarService(carDataAccessService);

    @Test
    void getAvailableCars() {
        var cars = carService.getAllCars();
        var expected = cars.stream()
                .filter(c -> !c.isBooked())
                .collect(Collectors.toList());

        List<Car> result = carService.getAvailableCars();

        assertEquals(expected, result);
    }


    @Test
    void getAvailableElectricCars() {
        var cars = carService.getAllCars();
        var expected = cars.stream()
                .filter(c -> c.isElectric() && !c.isBooked())
                .collect(Collectors.toList());

        var result = carService.getAvailableElectricCars();

        assertEquals(expected, result);
    }

    @Test
    void getAvailableCarByRegNumber() {
        var cars = carService.getAllCars();
        var firstCarREGNUMBER = cars.get(0).getREG_NUMBER().toString();
        var firstCar = cars.get(0);
        Car expected = null;
        if(!firstCar.isBooked())
            expected = firstCar;

        var result = carService.getAvailableCarByRegNumber(firstCarREGNUMBER);

        assertEquals(expected, result);
    }
}
