package kailuaCarRental.ui.flows.customer;

import kailuaCarRental.customer.CustomerService;

import java.util.Scanner;

public class CreateCustomerFlow {

    private final CustomerService service;

    public CreateCustomerFlow(CustomerService service) {
        this.service = service;
    }



        public void run(Scanner sc) {
            System.out.println("\n=== Opret kunde ===");


            String name    = promptRequired(sc, "Navn (krævet)");
            String address = prompt(sc, "Adresse");
            String zip     = prompt(sc, "Postnr");
            String city    = prompt(sc, "By");
            String phone   = prompt(sc, "Tlf");
            String email   = prompt(sc, "Email");


            System.out.println("\nDu er ved at oprette denne kunde:");
            System.out.println("Navn: " + name);
            System.out.println("Adresse: " + nvl(address));
            System.out.println("Postnr: " + nvl(zip));
            System.out.println("By: " + nvl(city));
            System.out.println("Tlf: " + nvl(phone));
            System.out.println("Email: " + nvl(email));
            System.out.print("Bekræft oprettelse (y/N): ");
            String ok = sc.nextLine().trim();
            if (!ok.equalsIgnoreCase("y")) {
                System.out.println("Afbryder. Ingen kunde oprettet.");
                return;
            }

            // Kald service
            int newId = service.addCustomer(name, address, zip, city, phone, email);
            System.out.println(newId > 0
                    ? "Kunde oprettet med id: " + newId
                    : "Kunne ikke oprette kunden.");
        }

        private String prompt(Scanner sc, String label) {
            System.out.print(label + ": ");
            String s = sc.nextLine();
            return s == null ? null : s.trim();
        }

        private String promptRequired(Scanner sc, String label) {
            while (true) {
                String s = prompt(sc, label);
                if (s != null && !s.isBlank()) return s;
                System.out.println("Feltet er krævet. Prøv igen.");
            }
        }

        private String nvl(String s) { return (s == null || s.isBlank()) ? "(tom)" : s; }

}





