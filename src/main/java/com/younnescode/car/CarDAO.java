package com.younnescode.car;

import java.util.List;

public interface CarDAO {
    List<Car> getCars();

    void update(Car car);
}
