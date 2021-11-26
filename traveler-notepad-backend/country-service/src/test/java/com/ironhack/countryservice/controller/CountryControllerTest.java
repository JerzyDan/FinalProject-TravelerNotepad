package com.ironhack.countryservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.countryservice.dao.Country;
import com.ironhack.countryservice.repositories.CountryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

        countryRepository.saveAll(List.of(country1,country2));
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
    void getCountryById() throws Exception{
        MvcResult result = mockMvc.perform(
                get("/api/v1/country/"+country1.getId())
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Jamaica"));
    }

    @Test
    void store() throws Exception{
        country1 = new Country("Fiji","fijian, english, fiji hindi, rotuman","tropical marine","18274");
        String body = objectMapper.writeValueAsString(country1);

        MvcResult result = mockMvc.perform(
                post("/api/v1/country/add")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("hindi"));
    }

    @Test
    void update() throws Exception{
        Country country = new Country("Romania");
        String body = objectMapper.writeValueAsString(country);

        MvcResult mvcResult = mockMvc.perform(
                put("/api/v1/country/"+country1.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        assertEquals("Romania",countryRepository.findById(country1.getId()).get().getName());
    }

    @Test
    void remove() throws Exception{
        long sizeBefore = countryRepository.count();

        MvcResult result = mockMvc.perform(
            delete("/api/v1/country/"+country2.getId())
        ).andExpect(status().isNoContent()).andReturn();

        long sizeAfter = countryRepository.count();
        assertEquals(--sizeBefore,sizeAfter);
    }
}