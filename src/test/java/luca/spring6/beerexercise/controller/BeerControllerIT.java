package luca.spring6.beerexercise.controller;

import jakarta.transaction.Transactional;
import luca.spring6.beerexercise.entities.Beer;
import luca.spring6.beerexercise.model.BeerDTO;
import luca.spring6.beerexercise.repositories.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerIT {

    @Autowired
    BeerController beerController;
    @Autowired
    BeerRepository beerRepository;

   @Test
   void TestBeerIdNotFound() {
       assertThrows(NotFundException.class, () -> {
           beerController.getBeerById((UUID.randomUUID()));
       });
   }

    @Test
    void testGetById() {
        Beer beer = beerRepository.findAll().get(0);
        BeerDTO dto = beerController.getBeerById((beer.getId()));
        assertThat(dto).isNotNull();
    }

    @Test
    void testListBeer() {
        List<BeerDTO> dtos = beerController.getBeers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Transactional
    @Rollback
    @Test
    void testEmptyList() {
        beerRepository.deleteAll();
        List<BeerDTO> dtos = beerController.getBeers();

        assertThat(dtos.size()).isEqualTo(0);
    }

}