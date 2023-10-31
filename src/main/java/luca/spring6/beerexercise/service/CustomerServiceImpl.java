package luca.spring6.beerexercise.service;

import lombok.extern.slf4j.Slf4j;
import luca.spring6.beerexercise.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
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

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {

        Customer existing = customerMap.get(customerId);
        existing.setCustomerName(customer.getCustomerName());
        existing.setCustomerLastName(customer.getCustomerLastName());
        existing.setAddress(customer.getAddress());

        customerMap.put(existing.getCustomerId(), existing);
    }

    @Override
    public void deleteCustomer(UUID customerId) {

        customerMap.remove(customerId);
    }
}
