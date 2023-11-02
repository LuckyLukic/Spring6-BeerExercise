package luca.spring6.beerexercise.mappers;
import luca.spring6.beerexercise.entities.Customer;
import luca.spring6.beerexercise.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer (CustomerDTO dto);

    CustomerDTO customerToCustomerDto (Customer customer);
}
