package com.cli.car;

import java.util.Arrays;
import java.util.List;

public class CarDAO {
    private static List<Car> carsList;

    static {
        Car[] cars = {
            new Car("123", true,"TESLA",89),
            new Car("453", false, "BMW", 120),
        };
        carsList = Arrays.asList(cars);
    }
    public List<Car> getAllCars() {
        return carsList;
    }

    public List<Car> getAllElectricCars() {
        return carsList.stream().filter(Car::isElectric).toList();
    };

    public Car getCarByRegNumber(String regNumber) {
        for(var car : carsList) {
            if(car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        return null;
    }
}
