package luca.spring6.beerexercise.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotBlank
    private String customerName;

    @NotNull
    @NotBlank
    private String customerLastName;

    @NotNull
    @NotBlank
    private String address;

    @Version
    private Integer version;
}
