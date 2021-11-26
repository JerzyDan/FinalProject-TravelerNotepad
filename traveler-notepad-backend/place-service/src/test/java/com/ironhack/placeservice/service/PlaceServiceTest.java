package com.ironhack.placeservice.service;

import com.ironhack.placeservice.dao.Place;
import com.ironhack.placeservice.enums.Status;
import com.ironhack.placeservice.repository.PlaceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlaceServiceTest {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceService placeService;

    Place storedPlace;
    Place newPlace;

    @BeforeEach
    void setUp() {
        storedPlace = new Place("Lomsdal-Visten nasjonalpark", Status.NEXT_TRIP);
        newPlace = new Place(1l,"Nordkapp", "Skarsvag", 21, Status.TO_VISIT, 5l);

        placeRepository.save(storedPlace);
    }

    @AfterEach
    void tearDown() {
        placeRepository.deleteAll();
    }

    @Test
    void update() {
        placeService.update(storedPlace.getId(),newPlace);

        assertEquals("Skarsvag",placeRepository.findById(storedPlace.getId()).get().getCity());
    }
}