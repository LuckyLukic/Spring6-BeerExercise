package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.model.Customer;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl () {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName("Luca")
                .customerLastName("Iannice")
                .address("Via Ciccio 123")
                .build();

        Customer customer2 = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName("Ariana")
                .customerLastName("Kirsch")
                .address("Via Ciccio 123")
                .build();

        customerMap.put(customer1.getCustomerId(), customer1);
        customerMap.put(customer2.getCustomerId(), customer2);
    }
    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        Customer savedCustomer = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName("Luca")
                .customerLastName("Iannice")
                .address("Via Ciccio 123")
                .build();

        customerMap.put(savedCustomer.getCustomerId(), savedCustomer);

        return savedCustomer;
    }
}
