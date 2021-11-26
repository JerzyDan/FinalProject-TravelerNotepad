package com.ironhack.countryservice.service;

import com.ironhack.countryservice.dao.Country;
import com.ironhack.countryservice.repositories.CountryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryServiceTest {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    Country storedCountry;
    Country newCountry;

    @BeforeEach
    void setUp() {
        storedCountry = new Country("New Zealand");
        newCountry = new Country(1l,"Andorra","Catalan","Continental and oceanic","470");

        countryRepository.save(storedCountry);
    }

    @AfterEach
    void tearDown() {
        countryRepository.deleteAll();
    }

    @Test
    void update() {
        countryService.update(storedCountry.getId(),newCountry);

        assertEquals("Andorra",countryRepository.findById(storedCountry.getId()).get().getName());
    }
}