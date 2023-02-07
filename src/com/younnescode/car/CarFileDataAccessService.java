package com.younnescode.car;

import java.io.*;
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
            while(scanner.hasNext()) {
                String fileLine = scanner.nextLine();
                String[] carFromFile = fileLine.split(",");
                int nextLineIndex = 0;

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
        Car[] cars = getCars();
        Car[] updatedCars = new Car[cars.length];

        for(int i = 0; i < cars.length; i++) {
            if(cars[i].getREG_NUMBER().equals(updatedCar.getREG_NUMBER())) {
                updatedCars[i] = updatedCar;
            } else {
                updatedCars[i] = cars[i];
            }
        }

        try (
                FileWriter fileWriter = new FileWriter(carsFile);
                PrintWriter printWriter = new PrintWriter(fileWriter);
        ) {
            printWriter.println("regNumber, rentalPricePerDay, brand, isElectric, isBooked");
            for (Car car : updatedCars) {
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
