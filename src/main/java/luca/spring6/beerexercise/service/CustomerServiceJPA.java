package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.mappers.CustomerMapper;
import luca.spring6.beerexercise.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary
public class CustomerServiceJPA implements CustomerService {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getCustomers() {
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return null;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteCustomer(UUID customerId) {

    }
}
