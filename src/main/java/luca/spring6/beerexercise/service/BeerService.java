package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.model.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    BeerDTO getBeerById (UUID id);

    List<BeerDTO> getBeers();

    BeerDTO saveBeer(BeerDTO beer);

    void updateBeer(UUID beerId, BeerDTO beer);

    void deleteBeer(UUID beerId);
}
