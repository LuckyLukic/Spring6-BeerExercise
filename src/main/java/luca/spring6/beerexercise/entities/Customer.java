package luca.spring6.beerexercise.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    
    @GeneratedValue
    @Column(length=36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID customerId;
    private String customerName;
    private String customerLastName;
    private String address;
    @Version
    private Integer version;
}
