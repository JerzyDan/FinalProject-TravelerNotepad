package com.ironhack.raportservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.raportservice.dao.Place;
import com.ironhack.raportservice.enums.Status;
import com.ironhack.raportservice.repositories.PlaceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RaportControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PlaceRepository placeRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Place place1;
    private Place place2;
    private Place place3;
    private Place place4;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        place1 = new Place("Triglav","Zgornja Radovna",1,Status.NEXT_TRIP,"Top of Slovenia",7l);
        place2 = new Place("Vernar","Goreljek",2, Status.NEXT_TRIP,"Vodnikov dom na Velem polju",7l);
        place3 = new Place("Old City Venezia","Venezia",7, Status.NEXT_TRIP,"Venezia and surroundings",6l);
        place4 = new Place("Col Rosa","Cortina d'Amprezzo",1, Status.FAVORITE,"Via Ferrata",6l);

        placeRepository.saveAll(List.of(place1,place2,place3,place4));
    }

    @AfterEach
    void tearDown() {
        placeRepository.deleteAll();
    }

    @Test
    void countPlacesByStatus() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/report/"+place1.getStatus())
        ).andExpect(status().isOk()).andReturn();

        assertEquals("3", result.getResponse().getContentAsString());
    }

    @Test
    void countCountriesByStatus() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/report/c/"+place1.getStatus())
        ).andExpect(status().isOk()).andReturn();

        assertEquals("2", result.getResponse().getContentAsString());
    }

    @Test
    void countDaysNeededByStatus() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/report/d/"+place1.getStatus())
        ).andExpect(status().isOk()).andReturn();

        assertEquals("10", result.getResponse().getContentAsString());
    }
}