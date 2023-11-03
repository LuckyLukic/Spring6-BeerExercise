package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.mappers.CustomerMapper;
import luca.spring6.beerexercise.model.BeerDTO;
import luca.spring6.beerexercise.model.CustomerDTO;
import luca.spring6.beerexercise.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service
@Primary
public class CustomerServiceJPA implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
        return Optional.ofNullable(customerMapper.customerToCustomerDto(customerRepository.findById(customerId)
                .orElse(null)));
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }



    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {

        return customerMapper.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customer)));
    }

    @Override
    public Optional<CustomerDTO> updateCustomer(UUID customerId, CustomerDTO customer) {

    AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();
        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
        foundCustomer.setCustomerName(customer.getCustomerName());
        foundCustomer.setCustomerLastName(customer.getCustomerLastName());
        foundCustomer.setAddress(customer.getAddress());

        atomicReference.set(Optional.of(customerMapper
                .customerToCustomerDto(customerRepository.save(foundCustomer))));
    }, () -> {
        atomicReference.set(Optional.empty());
    });

        return atomicReference.get();
}

    @Override
    public Boolean deleteCustomer(UUID customerId) {

        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }
}
