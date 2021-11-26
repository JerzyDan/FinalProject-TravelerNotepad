package com.ironhack.countryservice.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ironhack.countryservice.repositories.CountryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountryTest {

    @Autowired
    private CountryRepository countryRepository;

    private Country country1;

    @BeforeEach
    void setUp() {
        country1 = new Country("Trinidad and Tobago");
        countryRepository.save(country1);
    }

    @AfterEach
    void tearDown() {
        countryRepository.deleteAll();
    }

    @Test
    void setName_shouldWork() {
        country1.setName("Bostwana");
        assertEquals("Bostwana",country1.getName());
    }

}
