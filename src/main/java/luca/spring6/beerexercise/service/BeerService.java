package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    Beer getBeerById (UUID id);

    List<Beer> getBeers();

    Beer saveBeer(Beer beer);
}
