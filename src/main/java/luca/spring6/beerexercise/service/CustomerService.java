package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> getCustomers();

    Optional<CustomerDTO> getCustomerById(UUID customerId);

    CustomerDTO saveCustomer(CustomerDTO customer);

    Optional<CustomerDTO> updateCustomer(UUID customerId, CustomerDTO customer);

    Boolean deleteCustomer(UUID customerId);
}
