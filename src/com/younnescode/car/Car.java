package com.younnescode.car;

import java.math.BigDecimal;
import java.util.UUID;

public class Car {
    private UUID regNumber;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean isElectric;

    private static final CarService carService = new CarService();

    {
        this.regNumber = UUID.randomUUID();
    }

    public Car(BigDecimal rentalPricePerDay, Brand brand, boolean isElectric) {
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public UUID getRegNumber() {
        return regNumber;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public static Car[] getCars() {
        return carService.getCars();
    }

    public static Car[] getElectricCars() {
        return carService.getElectricCars();
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
