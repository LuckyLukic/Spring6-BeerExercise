package luca.spring6.beerexercise.service;

import lombok.extern.slf4j.Slf4j;
import luca.spring6.beerexercise.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

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
    public CustomerDTO getCustomerById(UUID customerId) {
        return customerMap.get(customerId);
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
    public void updateCustomer(UUID customerId, CustomerDTO customer) {

        CustomerDTO existing = customerMap.get(customerId);
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
