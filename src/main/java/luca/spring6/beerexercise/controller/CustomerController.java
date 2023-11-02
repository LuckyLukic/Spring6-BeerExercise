package luca.spring6.beerexercise.controller;

import luca.spring6.beerexercise.model.CustomerDTO;
import luca.spring6.beerexercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }


    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable UUID customerId) {
        return customerService.getCustomerById(customerId).orElseThrow(NotFundException::new);
    }

    @PostMapping("")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customer) {

        CustomerDTO savedCustomer = customerService.saveCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",  "/api/v1/customer/" + savedCustomer.getCustomerId() + toString());

        return new ResponseEntity<> (headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer (@PathVariable UUID customerId, @RequestBody CustomerDTO customer) {

        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> deleteCustomer (@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
