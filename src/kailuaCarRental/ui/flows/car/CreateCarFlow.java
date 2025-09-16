package kailuaCarRental.ui.flows.car;

import kailuaCarRental.car.CarService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreateCarFlow {

    private final CarService service;

    public CreateCarFlow(CarService service) {
        this.service = service;
    }


    public void run(Scanner sc) {
        try {
            System.out.print("Hvilken kategori? \n(1 = Luxury\n2 = Family\n3 = Sport): ");
            int categoryId = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Mærke: "); String brand = sc.nextLine().trim();
            System.out.print("Model: "); String model = sc.nextLine().trim();
            System.out.print("Nummerplade: "); String plate = sc.nextLine().trim();
            System.out.print("Brændstof (Petrol/Diesel/Hybrid/Electric): "); String fuel = sc.nextLine().trim();
            System.out.print("Odometer: "); int odo = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Første registrering (YYYY-MM-DD): ");
            LocalDate firstReg = LocalDate.parse(sc.nextLine().trim());

            int newId = service.addCar(categoryId, brand, model, plate, fuel, odo, firstReg);
            System.out.println(newId > 0 ? "Bil oprettet med id: " + newId : "Kunne ikke oprette bil.");
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Ugyldigt input: " + e.getMessage());
        }
    }
}
