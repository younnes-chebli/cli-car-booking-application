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

    private static int getAvailableCarsCpt() {
        int availableCarsCpt = 0;

        for (Car car : cars) {
            if(!car.isBooked()) {
                ++availableCarsCpt;
            }
        }

        return availableCarsCpt;
    }

    static Car[] getAvailableCars() {
        int availableCarsCpt = getAvailableCarsCpt();
        Car[] availableCars = new Car[availableCarsCpt];
        int nextAvailableIndex = 0;

        for (Car car : cars) {
            if (!car.isBooked() && nextAvailableIndex < getAvailableCarsCpt()) {
                availableCars[nextAvailableIndex++] = car;
            }
        }

        return availableCars;
    }

    static String[] getAvailableCarsRegNumbers() {
        Car[] availableCars = getAvailableCars();
        String[] availableCarsRegNumbers = new String[getAvailableCars().length];
        int nextAvailableIndex = 0;

        for (Car availableCar : availableCars) {
            if(nextAvailableIndex < getAvailableCars().length) {
                availableCarsRegNumbers[nextAvailableIndex++] = availableCar.getREG_NUMBER().toString();
            }
        }

        return availableCarsRegNumbers;
    }

    static Car[] getAvailableElectricCars() {
        Car[] electricCars = new Car[electricCarsCpt];
        var nextAvailableIndex = 0;

        for (Car car : cars) {
            if(car.isElectric() && nextAvailableIndex < electricCarsCpt) {

                electricCars[nextAvailableIndex++] = car;
            }
        }

        return electricCars;
    }
}
