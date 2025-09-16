package kailuaCarRental.model;

import java.time.LocalDate;

public class Car {
    private int carId;
    private int categoryId;
    private String brand;
    private String model;
    private String licensPlate;      // følger DB-kolonnen
    private String fuelType;         // Petrol/Diesel/Hybrid/Electric
    private int odometer;
    private LocalDate firstRegistrationDate;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensPlate() {
        return licensPlate;
    }

    public void setLicensPlate(String licensPlate) {
        this.licensPlate = licensPlate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public LocalDate getFirstRegistrationDate()
    { return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(LocalDate firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }


    @Override public String toString() {
        return carId + " | " + brand + " | " + model + " | " + licensPlate + " | " +
                fuelType + " | " + odometer + " | " + firstRegistrationDate;
    }
}
