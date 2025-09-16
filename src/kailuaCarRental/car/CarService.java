package kailuaCarRental.car;

import kailuaCarRental.model.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    // READ
    public List<Car> listAll() {

        return repo.findAll();
    }

    public Optional<Car> findById(int id) {
        return repo.findById(id);
    }

    // CREATE
    public int addCar(int categoryId, String brand, String model, String plate,
                      String fuelType, int odometer, LocalDate firstReg) {

        if (brand == null || brand.isBlank()) return -1;
        if (model == null || model.isBlank()) return -1;
        if (fuelType == null || fuelType.isBlank()) return -1;

        Car c = new Car();
        c.setCategoryId(categoryId);
        c.setBrand(brand);
        c.setModel(model);
        c.setLicensPlate(plate);
        c.setFuelType(fuelType);
        c.setOdometer(odometer);
        c.setFirstRegistrationDate(firstReg);

        return repo.insert(c);
    }

    // UPDATE (null/blank = uændret)
    public boolean updateCar(int id, Integer categoryId, String brand, String model,
                             String plate, String fuelType, Integer odometer, LocalDate firstReg) {

        Optional<Car> opt = repo.findById(id);
        if (opt.isEmpty()) return false;

        Car cur = opt.get();
        if (categoryId != null) cur.setCategoryId(categoryId);
        if (brand != null && !brand.isBlank()) cur.setBrand(brand);
        if (model != null && !model.isBlank()) cur.setModel(model);
        if (plate != null && !plate.isBlank()) cur.setLicensPlate(plate);
        if (fuelType != null && !fuelType.isBlank()) cur.setFuelType(fuelType);
        if (odometer != null) cur.setOdometer(odometer);
        if (firstReg != null) cur.setFirstRegistrationDate(firstReg);

        return repo.update(cur);
    }

    // DELETE
    public boolean removeCar(int id) { return repo.delete(id); }
}
