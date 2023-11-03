package luca.spring6.beerexercise.service;

import lombok.extern.slf4j.Slf4j;
import luca.spring6.beerexercise.model.CustomerDTO;
import luca.spring6.beerexercise.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl () {
        this.customerMap = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Luca")
                .customerLastName("Iannice")
                .address("Via Ciccio 123")
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Ariana")
                .customerLastName("Kirsch")
                .address("Via Ciccio 123")
                .build();

        customerMap.put(customer1.getCustomerId(), customer1);
        customerMap.put(customer2.getCustomerId(), customer2);
    }
    @Override
    public List<CustomerDTO> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
        return Optional.of(customerMap.get(customerId));

    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {

        CustomerDTO savedCustomer = CustomerDTO.builder()
                .customerId(UUID.randomUUID())
                .customerName("Luca")
                .customerLastName("Iannice")
                .address("Via Ciccio 123")
                .build();

        customerMap.put(savedCustomer.getCustomerId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public Optional<CustomerDTO> updateCustomer(UUID customerId, CustomerDTO customer) {

        CustomerDTO existing = customerMap.get(customerId);

        existing.setCustomerName(customer.getCustomerName());
        existing.setCustomerLastName(customer.getCustomerLastName());
        existing.setAddress(customer.getAddress());

        return Optional.of(existing);
    }

    @Override
    public Boolean deleteCustomer(UUID customerId) {

        customerMap.remove(customerId);

        return true;
    }
}
