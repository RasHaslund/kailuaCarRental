package kailuaCarRental.ui;

import kailuaCarRental.ui.flows.car.*;
import kailuaCarRental.ui.flows.customer.CreateCustomerFlow;
import kailuaCarRental.ui.flows.customer.ListCustomerFlow;

import java.util.Scanner;

public class Menu {
    private final ListCarFlow listCar;
    private final CreateCarFlow createCar;
    private final EditCarFlow editCar;
    private final DeleteCarFlow deleteCar;
    private final ListCustomerFlow listCustomer;
    private final CreateCustomerFlow createCustomer;


    public Menu(ListCarFlow listCar, CreateCarFlow createCar, EditCarFlow editCar, DeleteCarFlow deleteCar, ListCustomerFlow listCustomer, CreateCustomerFlow createCustomer) {
        this.listCar = listCar;
        this.createCar = createCar;
        this.editCar = editCar;
        this.deleteCar = deleteCar;
        this.listCustomer = listCustomer;
        this.createCustomer = createCustomer;

    }

    public void mainMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Hovedmenu ===");
                System.out.println("1) Kunde-Menu");
                System.out.println("2) Udlejnings-Menu");
                System.out.println("3) Bil-Menu");
                System.out.println("0) Exit");
                System.out.print("Choose: ");
                switch (sc.nextLine().trim()) {
                    case "1" -> showCustomerMenu(sc);
                    case "2" -> System.out.println("Har ikke lavet rental endnu..");
                    case "3" -> showCarMenu(sc);
                    case "0" -> {
                        System.out.println("vi ses igen!");
                        return;
                    }
                    default -> System.out.println("Unknown choice.");
                }
            }
        }
    }

    private void showCarMenu(Scanner sc) {
        while (true) {
            System.out.println("\n-- Car Menu --");
            System.out.println("1) Se biler");
            System.out.println("2) Tilføj bil");
            System.out.println("3) Rediger bil");
            System.out.println("4) Slet bil");
            System.out.println("0) Tilbage");
            System.out.print("Vælg: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1" -> listCar.run();
                case "2" -> createCar.run(sc);
                case "3" -> editCar.run(sc);
                case "4" -> deleteCar.run(sc);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Ukendt valg.");
            }
        }
    }

    private void showCustomerMenu(Scanner sc) {
        while (true) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1) Vis kunder");
            System.out.println("2) Opret Kunde");
            System.out.println("0) Tilbage");
            System.out.print("Vælg: ");
            switch (sc.nextLine().trim()) {
                case "1" -> listCustomer.run();
                case "2" -> createCustomer.run(sc);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Ukendt valg.");
            }
        }
    }
}
