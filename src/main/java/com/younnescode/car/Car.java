package com.younnescode.car;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Car {
    private final UUID REG_NUMBER;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean isElectric;
    private boolean isBooked;

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

    public UUID getREG_NUMBER() {
        return REG_NUMBER;
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

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isElectric == car.isElectric && isBooked == car.isBooked && Objects.equals(REG_NUMBER, car.REG_NUMBER) && Objects.equals(rentalPricePerDay, car.rentalPricePerDay) && brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(REG_NUMBER, rentalPricePerDay, brand, isElectric, isBooked);
    }

    @Override
    public String toString() {
        return "Car{" +
                "REG_NUMBER=" + REG_NUMBER +
                ", rentalPricePerDay=" + rentalPricePerDay + "€" +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                ", isBooked=" + isBooked +
                '}';
    }
}
