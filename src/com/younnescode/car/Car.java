package com.younnescode.car;

import java.math.BigDecimal;
import java.util.UUID;

public class Car {
    private final UUID REG_NUMBER;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean isElectric;
    private boolean isBooked;

    private static final CarService carService = new CarService();

    {
        this.REG_NUMBER = UUID.randomUUID();
    }

    public Car(BigDecimal rentalPricePerDay, Brand brand, boolean isElectric) {
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isBooked = false;
    }

    public static int getCarsCpt() {
        return carService.getCarsCpt();
    }

    public boolean isElectric() {
        return isElectric;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public UUID getREG_NUMBER() {
        return REG_NUMBER;
    }

    public static Car[] getAvailableCars() {
        return carService.getAvailableCars();
    }

    public static Car getAvailableCarByRegNumber(String regNumber) {
        return carService.getAvailableCarByRegNumber(regNumber);
    }

    public static Car[] getAvailableElectricCars() {
        return carService.getAvailableElectricCars();
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber=" + REG_NUMBER +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }
}
