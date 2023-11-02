package luca.spring6.beerexercise.mappers;

import luca.spring6.beerexercise.entities.Beer;
import luca.spring6.beerexercise.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer (BeerDTO dto);

    BeerDTO beerToBeerDto (Beer beer);
}
