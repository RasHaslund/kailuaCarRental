package kailuaCarRental.ui.flows.car;

import kailuaCarRental.car.CarService;
import kailuaCarRental.model.Car;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class EditCarFlow {

    private final CarService service;

    public EditCarFlow(CarService service) {
        this.service = service;
    }


    public void run(Scanner sc) {

        try {
            System.out.print("Nummerpladen på den bil der skal redigeres: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            Optional<Car> curOpt = service.findById(id);
            if (curOpt.isEmpty()) { System.out.println("Bil findes ikke."); return; }
            Car cur = curOpt.get();

            System.out.print("Ny Category_ID (" + cur.getCategoryId() + ", ENTER=uændret): ");
            String t = sc.nextLine().trim();
            Integer categoryId = t.isBlank() ? null : Integer.parseInt(t);

            System.out.print("Ny Brand (" + cur.getBrand() + ", ENTER =u ændret): ");
            t = sc.nextLine().trim(); String brand = t.isBlank() ? null : t;

            System.out.print("Ny Model (" + cur.getModel() + ", ENTER = uændret): ");
            t = sc.nextLine().trim(); String model = t.isBlank() ? null : t;

            System.out.print("Ny License plate (" + cur.getLicensPlate() + ", ENTER = uændret): ");
            t = sc.nextLine().trim(); String plate = t.isBlank() ? null : t;

            System.out.print("Ny FuelType (" + cur.getFuelType() + ", ENTER = uændret): ");
            t = sc.nextLine().trim(); String fuel = t.isBlank() ? null : t;

            System.out.print("Ny Odometer (" + cur.getOdometer() + ", ENTER = uændret): ");
            t = sc.nextLine().trim(); Integer odo = t.isBlank() ? null : Integer.parseInt(t);

            System.out.print("Ny First reg (YYYY-MM-DD) (" + cur.getFirstRegistrationDate() + ", ENTER = uændret): ");
            t = sc.nextLine().trim(); LocalDate firstReg = t.isBlank() ? null : LocalDate.parse(t);

            boolean ok = service.updateCar(id, categoryId, brand, model, plate, fuel, odo, firstReg);
            System.out.println(ok ? "Bil opdateret." : "Opdatering fejlede.");

        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Ugyldigt input: " + e.getMessage());
        }
    }
}
