package luca.spring6.beerexercise.service;

import luca.spring6.beerexercise.mappers.BeerMapper;
import luca.spring6.beerexercise.model.BeerDTO;
import luca.spring6.beerexercise.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
public class BeerServiceJPA implements BeerService {

    @Autowired
    BeerRepository beerRepository;
    @Autowired
    BeerMapper beerMapper;

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beerToBeerDto(beerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public List<BeerDTO> getBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::beerToBeerDto)
                .collect(Collectors.toList());
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beer) {

        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beer)));
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beer) {
        beerRepository.findById(beerId).ifPresent(foundBeer -> {
            foundBeer.setBeerName(beer.getBeerName());
            foundBeer.setBeerStyle(beer.getBeerStyle());
            foundBeer.setUpc(beer.getUpc());
            foundBeer.setPrice(beer.getPrice());

            beerRepository.save(foundBeer);
        });
    }

    @Override
    public void deleteBeer(UUID beerId) {


    }
}
