package kailuaCarRental.ui.flows.car;

import kailuaCarRental.car.CarService;
import kailuaCarRental.model.Car;

import java.util.List;

public class ListCarFlow {

    private final CarService service;

    public ListCarFlow(CarService service) {
        this.service = service;
    }

    // Printer en liste af alle oprettede biler
    public void run() {
        List<Car> cars = service.listAll();
        if (cars.isEmpty()) {
            System.out.println("(ingen biler i databasen)");
            return;
        }
        System.out.println("ID | Brand | Model | Plate | Fuel | Odo | RegDate\n" +
                "_______________________________________________________________________");
        for (Car c : cars) System.out.println(c);
    }
}
