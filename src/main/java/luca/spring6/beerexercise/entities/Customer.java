package luca.spring6.beerexercise.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @JdbcTypeCode(SqlTypes.CHAR)// specifically tells hibernate to convert UUID into a string
    @Column(length=36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
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
