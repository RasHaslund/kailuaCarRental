package kailuaCarRental.ui.flows.customer;

import java.util.List;
import kailuaCarRental.customer.CustomerService;
import kailuaCarRental.model.Customer;

public class ListCustomerFlow {

    private final CustomerService service;

    public ListCustomerFlow(CustomerService service) {
        this.service = service;
    }

    public void run() {

        List<Customer> customers = service.listAll();

        if (customers.isEmpty()) {
            System.out.println("(ingen kunder)");
            return;
        }
        System.out.println("ID | Navn | Adresse | Postnr | By | Tlf | Email");

        customers.forEach(System.out::println);
    }
}
