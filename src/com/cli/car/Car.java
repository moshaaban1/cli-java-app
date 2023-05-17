package com.cli.car;

public class Car {
    private String regNumber;
    private boolean isElectric;
    private String brand;
    private double rentalPricePerDay;

    public Car(String regNumber, boolean isElectric, String brand, double rentalPricePerDay) {
        this.regNumber = regNumber;
        this.isElectric = isElectric;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", isElectric=" + isElectric +
                ", brand='" + brand + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                '}';
    }
}
