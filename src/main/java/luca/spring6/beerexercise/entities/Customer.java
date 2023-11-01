package luca.spring6.beerexercise.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import lombok.*;

import java.util.UUID;


@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private UUID customerId;
    private String customerName;
    private String customerLastName;
    private String address;
    @Version
    private Integer version;
}
