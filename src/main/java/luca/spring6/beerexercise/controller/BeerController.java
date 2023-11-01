package luca.spring6.beerexercise.controller;

import lombok.extern.slf4j.Slf4j;
import luca.spring6.beerexercise.model.Beer;
import luca.spring6.beerexercise.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
     BeerService beerService;

    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable UUID beerId) throws NotFundException{

        return Optional.ofNullable(beerService.getBeerById(beerId)).orElseThrow(NotFundException::new);
    }

    @GetMapping("")
    public List<Beer> getBeers() {
        log.info("Retrieving all beers");

        return beerService.getBeers();
    }

    @PostMapping("")
    public ResponseEntity<Beer> saveBeer(@RequestBody Beer beer) {

        Beer savedBeer = beerService.saveBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Beer> updateBeer (@PathVariable UUID beerId, @RequestBody Beer beer) {

       beerService.updateBeer(beerId, beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Beer> deleteBeer (@PathVariable UUID beerId){

        beerService.deleteBeer(beerId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
