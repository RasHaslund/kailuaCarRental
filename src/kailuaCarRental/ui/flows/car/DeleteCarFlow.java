package kailuaCarRental.ui.flows.car;

import kailuaCarRental.car.CarService;

import java.util.Scanner;

public class DeleteCarFlow {

    private final CarService service;

    public DeleteCarFlow(CarService service) {
        this.service = service;
    }

    public void run(Scanner sc) {

        try {
            System.out.print("Car_ID der skal slettes: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Er du sikker? (y/N): ");
            String confirm = sc.nextLine().trim().toLowerCase();

            if (!confirm.equals("y")) { System.out.println("Afbryder."); return; }

            boolean ok = service.removeCar(id);

            System.out.println(ok ? "Bil slettet." : "Kunne ikke slette (måske bruges bilen i kontrakt).");

        } catch (NumberFormatException e) {
            System.out.println("Ugyldigt id.");
        }
    }
}
