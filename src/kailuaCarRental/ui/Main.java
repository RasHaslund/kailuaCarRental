package kailuaCarRental.ui;

import kailuaCarRental.car.*;
import kailuaCarRental.customer.CustomerRepository;
import kailuaCarRental.customer.CustomerRepositoryDB;
import kailuaCarRental.customer.CustomerService;
import kailuaCarRental.ui.flows.car.*;
import kailuaCarRental.ui.flows.customer.*;


import kailuaCarRental.ui.flows.customer.ListCustomerFlow;

public class Main {
    public static void main(String[] args) {

        // repo + service
        CarRepository carRepo = new CarRepositoryDB();
        CarService carService = new CarService(carRepo);
        CustomerRepository customerRepo = new CustomerRepositoryDB();
        CustomerService customerService = new CustomerService(customerRepo);

        // ui-flows
        ListCarFlow listCar = new ListCarFlow(carService);
        CreateCarFlow createCar = new CreateCarFlow(carService);
        EditCarFlow editCar = new EditCarFlow(carService);
        DeleteCarFlow deleteCar = new DeleteCarFlow(carService);


        ListCustomerFlow listCustomer = new ListCustomerFlow(customerService);
        CreateCustomerFlow createCustomer = new CreateCustomerFlow(customerService);

        // menu
        Menu m = new Menu(listCar, createCar, editCar, deleteCar, listCustomer, createCustomer);

        m.mainMenu();
    }
}
