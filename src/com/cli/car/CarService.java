package com.cli.car;

import java.util.List;

public class CarService {
    private CarDAO carDAO;
    public CarService() {
        this.carDAO = new CarDAO();
    }

    public List<Car> getAllAvailableElectricCars() {
       return this.carDAO.getAllElectricCars();
    }

    public List<Car> getAllAvailableCars() {
        return this.carDAO.getAllCars();
    }

    public Car getCarByRegNumber(String regNumber) {
        return this.carDAO.getCarByRegNumber(regNumber);
    }
}
