package kailuaCarRental.car;

import kailuaCarRental.model.Car;
import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> findAll();
    Optional<Car> findById(int carId);
    int insert(Car c);           // returnerer genereret Car_ID (>0) eller -1
    boolean update(Car c);
    boolean delete(int carId);
}
