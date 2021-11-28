package com.ironhack.raportservice.controller;

import com.ironhack.raportservice.enums.Status;
import com.ironhack.raportservice.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/report")
public class RaportController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/vp")
    @ResponseStatus(HttpStatus.OK)
    public Integer visitedPlaces() {
        return placeRepository.FindByStatusCountByName(Status.VISITED);
    }

}
