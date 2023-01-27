package com.younnescode.car;

import java.math.BigDecimal;

public class CarDao {
    private static final Car[] cars;
    private static int electricCarsCpt = 1;
    private static int carsCpt = 3;

    static {
        cars = new Car[]{
            new Car(new BigDecimal(89).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.TESLA, true),
            new Car(new BigDecimal(50).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.AUDI, false),
            new Car(new BigDecimal(77).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.MERCEDES, false)
        };
    }

    static int getCarsCpt() {
        return carsCpt;
    }

    public static int getElectricCarsCpt() {
        return electricCarsCpt;
    }

    static Car[] getAllCars() {
        return cars;
    }
}
