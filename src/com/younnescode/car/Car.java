package com.younnescode.car;

import java.math.BigDecimal;
import java.util.UUID;

public class Car {
    private UUID regNumber;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean isElectric;
    private boolean isBooked;

    private static final CarService carService = new CarService();

    {
        this.regNumber = UUID.randomUUID();
    }

    public Car(BigDecimal rentalPricePerDay, Brand brand, boolean isElectric) {
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isBooked = false;
    }

    public static int getCarsCpt() {
        return CarService.getCarsCpt();
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public static Car[] getAvailableCars() {
    return carService.getAvailableCars();
    }

    public static Car[] getAvailableElectricCars() {
        return carService.getAvailableElectricCars();
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber=" + regNumber +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }
}
