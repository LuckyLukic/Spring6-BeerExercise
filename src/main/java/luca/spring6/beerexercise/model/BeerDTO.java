package luca.spring6.beerexercise.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class BeerDTO {

        private UUID id;
        private Integer version;

        @NotNull
        @NotBlank
        @Size(max = 50) //bean validation constraint ( do not hit the DB)
        @Column(length = 50) //DB constraint
        private String beerName;

        @NotNull
        private BeerStyle beerStyle;

        @NotNull
        @NotBlank
        private String upc;

        private Integer quantityOnHand;

        @NotNull
        private BigDecimal price;
        private LocalDateTime createdDate;
        private LocalDateTime updateDate;
}
