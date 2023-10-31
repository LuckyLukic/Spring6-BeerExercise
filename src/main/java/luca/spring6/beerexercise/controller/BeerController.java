package luca.spring6.beerexercise.controller;

import luca.spring6.beerexercise.model.Beer;
import luca.spring6.beerexercise.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
