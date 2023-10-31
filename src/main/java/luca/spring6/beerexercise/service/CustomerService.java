package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

     List<Customer> getCustomers();

    Customer getCustomerById(UUID customerId);

    Customer saveCustomer(Customer customer);

    void updateCustomer(UUID customerId, Customer customer);

    void deleteCustomer(UUID customerId);
}