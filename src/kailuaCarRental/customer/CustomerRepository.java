package kailuaCarRental.customer;

import kailuaCarRental.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();
    Customer findByID(int customerId);
    int insert(Customer customer);
    boolean update(Customer customer);
    boolean delete(int customerId);

}
