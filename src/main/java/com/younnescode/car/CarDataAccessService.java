package com.younnescode.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarDataAccessService implements CarDAO {
    private static final List<Car> cars;

    static {
                cars = new ArrayList<>();
                cars.add(new Car(new BigDecimal(89).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.TESLA, true));
                cars.add(new Car(new BigDecimal(50).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.AUDI, false));
                cars.add(new Car(new BigDecimal(77).setScale(2, BigDecimal.ROUND_HALF_EVEN), Brand.MERCEDES, false));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public void update(Car car) {

    }
}