package com.ironhack.countryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.countryservice.dao.Country;
import com.ironhack.countryservice.repositories.CountryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CountryControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CountryRepository countryRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Country country1;
    private Country country2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        country1 = new Country("Jamaica");
        country2 = new Country("Vanuatu"," bislama, english, french","Humid equatorial","121909");
    }

    @AfterEach
    void tearDown() {
        countryRepository.deleteAll();
    }

    @Test
    void getCountries() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/country")
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("bislama"));
    }

    @Test
    void getCountryById() {
    }

    @Test
    void store() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}