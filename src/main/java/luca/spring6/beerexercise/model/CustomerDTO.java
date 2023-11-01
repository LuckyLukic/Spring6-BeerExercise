package luca.spring6.beerexercise.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CustomerDTO {
    private UUID customerId;
    private String customerName;
    private String customerLastName;
    private String address;

}
