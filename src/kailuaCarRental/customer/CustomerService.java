package kailuaCarRental.customer;
import java.util.List;

import kailuaCarRental.customer.CustomerRepository;
import kailuaCarRental.model.Customer;

public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public int addCustomer(String name, String address, String zip, String city, String phone, String email) {
        if (name == null || name.isBlank()) return -1;

        Customer customer = new Customer();
        customer.setName(name.trim());
        customer.setAddress(address == null ? null : address.trim());
        customer.setZip(zip == null ? null : zip.trim());
        customer.setCity(city == null ? null : city.trim());
        customer.setPhone(phone == null ? null : phone.trim());
        customer.setEmail(email == null ? null : email.trim());

        return repo.insert(customer);
    }


}
