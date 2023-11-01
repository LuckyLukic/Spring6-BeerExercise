package luca.spring6.beerexercise.repositories;

import luca.spring6.beerexercise.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("Magic")
                .build());
        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();

    }
}