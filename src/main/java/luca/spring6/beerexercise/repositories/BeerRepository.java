package luca.spring6.beerexercise.repositories;

import luca.spring6.beerexercise.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
