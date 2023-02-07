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

    public Car(BigDecimal rentalPricePerDay, Brand brand, boolean isElectric) {
        this.REG_NUMBER = UUID.randomUUID();
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isBooked = false;
    }

    public Car(UUID REG_NUMBER, BigDecimal rentalPricePerDay, Brand brand, boolean isElectric, boolean isBooked) {
        this.REG_NUMBER = REG_NUMBER;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
        this.isBooked = isBooked;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
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

    public void setBooked(boolean booked) {
        isBooked = booked;
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

    public void update() {
        carService.update(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "REG_NUMBER=" + REG_NUMBER +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                ", isBooked=" + isBooked +
                '}';
    }
}
