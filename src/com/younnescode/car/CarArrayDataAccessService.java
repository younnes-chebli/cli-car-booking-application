package com.younnescode.car;

import java.math.BigDecimal;

public class CarArrayDataAccessService implements CarDAO {
    private static final Car[] cars;

    static {
        cars = new Car[]{
            new Car(new BigDecimal(89).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.TESLA, true),
            new Car(new BigDecimal(50).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.AUDI, false),
            new Car(new BigDecimal(77).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.MERCEDES, false)
        };
    }

    @Override
    public Car[] getCars() {
        return cars;
    }
}
