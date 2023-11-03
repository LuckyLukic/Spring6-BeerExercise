package luca.spring6.beerexercise.controller;

import lombok.extern.slf4j.Slf4j;
import luca.spring6.beerexercise.model.BeerDTO;
import luca.spring6.beerexercise.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @Autowired
     BeerService beerService;

    @GetMapping("")
    public List<BeerDTO> getBeers() {return beerService.getBeers();
    }

    @GetMapping("/{beerId}")
    public BeerDTO getBeerById(@PathVariable UUID beerId) {
        return beerService.getBeerById(beerId).orElseThrow(NotFundException::new);
    }

    @PostMapping("")
    public ResponseEntity<BeerDTO> saveBeer(@RequestBody BeerDTO beer) {

        BeerDTO savedBeer = beerService.saveBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer (@PathVariable UUID beerId, @RequestBody BeerDTO beer) {

      if(beerService.updateBeer(beerId, beer).isEmpty()) {
          throw new NotFundException();
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDTO> deleteBeer (@PathVariable UUID beerId){

       if (!beerService.deleteBeer(beerId)) {
           throw new NotFundException();
       }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
