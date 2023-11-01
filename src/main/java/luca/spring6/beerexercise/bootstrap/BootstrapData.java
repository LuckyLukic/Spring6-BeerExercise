package luca.spring6.beerexercise.bootstrap;

import luca.spring6.beerexercise.entities.Beer;
import luca.spring6.beerexercise.entities.Customer;
import luca.spring6.beerexercise.model.BeerStyle;
import luca.spring6.beerexercise.repositories.BeerRepository;
import luca.spring6.beerexercise.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    BeerRepository beerRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

        private void loadBeerData() {
            if (beerRepository.count() == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Galaxy Cat")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("12356")
                        .price(new BigDecimal("12.99"))
                        .quantityOnHand(122)
                        .createdDate(LocalDateTime.now())
                        .updateDate(LocalDateTime.now())
                        .build();

                Beer beer2 = Beer.builder()
                        .beerName("Crank")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("12356222")
                        .price(new BigDecimal("11.99"))
                        .quantityOnHand(392)
                        .createdDate(LocalDateTime.now())
                        .updateDate(LocalDateTime.now())
                        .build();

                Beer beer3 = Beer.builder()
                        .beerName("Sunshine City")
                        .beerStyle(BeerStyle.IPA)
                        .upc("12356")
                        .price(new BigDecimal("13.99"))
                        .quantityOnHand(144)
                        .createdDate(LocalDateTime.now())
                        .updateDate(LocalDateTime.now())
                        .build();

                beerRepository.save(beer1);
                beerRepository.save(beer2);
                beerRepository.save(beer3);
            }
        }

            private void loadCustomerData() {

                if (customerRepository.count() == 0) {
                    Customer customer1 = Customer.builder()
                            .customerName("Customer 1")
                            .customerLastName("CustomerLastName 1 ")
                            .address("qwer 123")
                            .version(1)
                            .build();

                    Customer customer2 = Customer.builder()
                            .customerName("Customer 2")
                            .customerLastName("CustomerLastName 2 ")
                            .address("qwerqwer 123")
                            .version(1)
                            .build();

                    Customer customer3 = Customer.builder()
                            .customerName("Customer 3")
                            .customerLastName("CustomerLastName 3 ")
                            .address("qwerqwerqwer 123")
                            .version(1)
                            .build();

                    customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
                }


            }


    }

