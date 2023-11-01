package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.model.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

     List<CustomerDTO> getCustomers();

    CustomerDTO getCustomerById(UUID customerId);

    CustomerDTO saveCustomer(CustomerDTO customer);

    void updateCustomer(UUID customerId, CustomerDTO customer);

    void deleteCustomer(UUID customerId);
}
