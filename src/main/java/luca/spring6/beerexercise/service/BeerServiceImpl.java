package luca.spring6.beerexercise.service;

import lombok.extern.slf4j.Slf4j;
import luca.spring6.beerexercise.model.BeerDTO;
import luca.spring6.beerexercise.model.BeerStyle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {


    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
            this.beerMap = new HashMap<>();

            BeerDTO beer1 = BeerDTO.builder()
                    .id(UUID.randomUUID())
                    .version(1)
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerDTO beer2 = BeerDTO.builder()
                    .id(UUID.randomUUID())
                    .version(1)
                    .beerName("Crank")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerDTO beer3 = BeerDTO.builder()
                    .id(UUID.randomUUID())
                    .version(1)
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyle.IPA)
                    .upc("12356")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(144)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerMap.put(beer1.getId(), beer1);
            beerMap.put(beer2.getId(), beer2);
            beerMap.put(beer3.getId(), beer3);

        }

    @Override
    public List<BeerDTO> getBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beer) {

        BeerDTO savedBeer = BeerDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;

    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beer) {

        BeerDTO existing = beerMap.get(beerId);

        existing.setBeerName(beer.getBeerName());
        existing.setPrice(beer.getPrice());
        existing.setUpc(beer.getUpc());
        existing.setQuantityOnHand(beer.getQuantityOnHand());

        beerMap.put(existing.getId(), existing);
    }

    @Override
    public void deleteBeer(UUID beerId) {

        beerMap.remove(beerId);
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return Optional.ofNullable(beerMap.get(id));
    }
}
