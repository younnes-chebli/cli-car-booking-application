package com.younnescode.car;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.UUID;

public class CarFileDataAccessService implements CarDAO {
    private static final File carsFile = new File("src/com/younnescode/files/cars.csv");

    @Override
    public Car[] getCars() {
        Car[] cars = new Car[3];
        int nextAvailableIndex = 0;

        try {
            Scanner scanner = new Scanner(carsFile);

            scanner.nextLine();
            while(scanner.hasNext() && nextAvailableIndex < cars.length) {
                String fileLine = scanner.nextLine();
                String[] carFromFile = fileLine.split(",");
                int nextLineIndex = 0;

                try {
                    cars[nextAvailableIndex++] = new Car(
                            UUID.fromString(carFromFile[nextLineIndex++].trim()),
                            new BigDecimal(carFromFile[nextLineIndex++].trim()).setScale(2, BigDecimal.ROUND_HALF_EVEN),
                            Brand.valueOf(carFromFile[nextLineIndex++].trim()),
                            Boolean.parseBoolean(carFromFile[nextLineIndex++].trim()),
                            Boolean.parseBoolean(carFromFile[nextLineIndex++].trim()));
                } catch(IllegalArgumentException e) {
                    e.getMessage();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }
}
