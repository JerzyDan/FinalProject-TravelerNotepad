package com.ironhack.placeservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.placeservice.dao.Place;
import com.ironhack.placeservice.enums.Status;
import com.ironhack.placeservice.repository.PlaceRepository;
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
class PlaceControllerTest {

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

        place1 = new Place("Ilha do Fogo ", Status.NEXT_TRIP);
        place2 = new Place("Dominica","Tongon",14,Status.FAVORITE,1l);

        placeRepository.saveAll(List.of(place1,place2));
    }

    @AfterEach
    void tearDown() {
        placeRepository.deleteAll();
    }

    @Test
    void getPlaces() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/places")
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Tongon"));
    }

    @Test
    void getPlaceById() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/api/v1/places/"+place1.getId())
        ).andExpect(status().isOk()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Fogo"));
    }

    @Test
    void store() throws Exception {
        place1 = new Place("Saint Helena Island","High Knoll Fort",7,Status.TO_VISIT,2l);
        String body = objectMapper.writeValueAsString(place1);

        MvcResult result = mockMvc.perform(
                post("/api/v1/places/add")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Helena"));
    }

    @Test
    void update() throws Exception {
        Place place = new Place("Ibiza",Status.VISITED);
        String body = objectMapper.writeValueAsString(place);

        MvcResult mvcResult = mockMvc.perform(
                put("/api/v1/places/"+place1.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();

        assertEquals("Ibiza",placeRepository.findById(place1.getId()).get().getName());
    }

    @Test
    void remove() throws Exception {
        long sizeBefore = placeRepository.count();

        MvcResult result = mockMvc.perform(
                delete("/api/v1/places/"+place2.getId())
        ).andExpect(status().isNoContent()).andReturn();

        long sizeAfter = placeRepository.count();
        assertEquals(--sizeBefore,sizeAfter);
    }
}