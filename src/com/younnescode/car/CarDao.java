package com.younnescode.car;

import java.math.BigDecimal;

public class CarDao {
    private static final Car[] cars;
    private static int electricCarsCpt = 1;

    static {
        cars = new Car[]{
            new Car(new BigDecimal(89), Brand.TESLA, true),
            new Car(new BigDecimal(50), Brand.AUDI, false),
            new Car(new BigDecimal(77), Brand.MERCEDES, false)
        };
    }

    Car[] getCars() {
        return cars;
    }

    Car[] getElectricCars() {
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
