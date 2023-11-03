package luca.spring6.beerexercise.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CustomerDTO {
    private UUID customerId;
    @NotNull
    private String customerName;
    @NotNull
    private String customerLastName;
    @NotNull
    private String address;

}
