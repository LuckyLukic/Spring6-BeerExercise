package luca.spring6.beerexercise.controller;

import luca.spring6.beerexercise.model.Beer;
import luca.spring6.beerexercise.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
    BeerService beerService;

    @GetMapping("{beerId")
    public Beer getBeerById(@PathVariable UUID id){

        return beerService.getBeerById(id);
    }

    @GetMapping("")
    public List<Beer> getBeers() {

        return beerService.getBeers();
    }

    @PostMapping("")
    public ResponseEntity<Beer> saveBeer(@RequestBody Beer beer) {

        Beer savedBeer = beerService.saveBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

}
