package luca.spring6.beerexercise.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    @Column(length=36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID customerId;
    private String customerName;
    private String customerLastName;
    private String address;
    @Version
    private Integer version;
}
