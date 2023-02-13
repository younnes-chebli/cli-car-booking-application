package com.younnescode.car;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.UUID;

public class CarFileDataAccessService implements CarDAO {
    private static final File carsFile = new File("src/com/younnescode/files/cars.csv");

    @Override
    public Car[] getCars() {
        var cars = new Car[3];
        var nextAvailableIndex = 0;

        try {
            var scanner = new Scanner(carsFile);

            scanner.nextLine();
            while(scanner.hasNext()) {
                var fileLine = scanner.nextLine();
                var carFromFile = fileLine.split(",");
                var nextLineIndex = 0;

                try {
                    cars[nextAvailableIndex++] = new Car(
                            UUID.fromString(carFromFile[nextLineIndex++].trim()),
                            new BigDecimal(carFromFile[nextLineIndex++].trim()).setScale(2, BigDecimal.ROUND_HALF_EVEN),
                            Brand.valueOf(carFromFile[nextLineIndex++].trim()),
                            Boolean.parseBoolean(carFromFile[nextLineIndex++].trim()),
                            Boolean.parseBoolean(carFromFile[nextLineIndex++].trim())
                    );
                } catch(IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }

    @Override
    public void update(Car updatedCar) {
        var cars = getCars();
        var updatedCars = new Car[cars.length];

        for(var i = 0; i < cars.length; i++) {
            if(cars[i].getREG_NUMBER().equals(updatedCar.getREG_NUMBER())) {
                updatedCars[i] = updatedCar;
            } else {
                updatedCars[i] = cars[i];
            }
        }

        try (
                var fileWriter = new FileWriter(carsFile);
                var printWriter = new PrintWriter(fileWriter);
        ) {
            printWriter.println("regNumber, rentalPricePerDay, brand, isElectric, isBooked");
            for (var car : updatedCars) {
                printWriter.print(
                        car.getREG_NUMBER()+ ", " +
                        car.getRentalPricePerDay() + ", " +
                        car.getBrand() + ", " +
                        car.isElectric() + ", " +
                        car.isBooked()
                );
                printWriter.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
