package com.ironhack.searchservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.searchservice.dao.Place;
import com.ironhack.searchservice.enums.Status;
import com.ironhack.searchservice.repositories.PlaceRepository;
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
class SearchControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PlaceRepository placeRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Place place1;
    private Place place2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        place1 = new Place("Deildartunguhver","Kleppjárnsreykir",1,Status.NEXT_TRIP,"thermal water stand ",6l);
        place2 = new Place("Korokaha","Tongon",3,Status.FAVORITE,"Gold mine",7l);

        placeRepository.saveAll(List.of(place1,place2));
    }

    @AfterEach
    void tearDown() {
        placeRepository.deleteAll();
    }

    @Test
    void getPlaceByName() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/search/"+place1.getName())
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("thermal water"));
    }

    @Test
    void getPlacesByCity() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/search/c/"+place2.getCity())
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Korokaha"));
    }

    @Test
    void getPlacesByStatus() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/search/s/"+place1.getStatus())
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Deildartunguhver"));
    }

    @Test
    void getPlacesByDays() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/search/d/3")
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Gold mine"));
        assertTrue(result.getResponse().getContentAsString().contains("NEXT_TRIP"));
    }

    @Test
    void getPlacesByCountry() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/search/ca/6")
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("water stand"));
    }
}