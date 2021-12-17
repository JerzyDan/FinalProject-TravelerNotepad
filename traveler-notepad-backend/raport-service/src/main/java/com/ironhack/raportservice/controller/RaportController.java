package com.ironhack.raportservice.controller;

import com.ironhack.raportservice.enums.Status;
import com.ironhack.raportservice.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/report")
public class RaportController {

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/{status}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public Integer countPlacesByStatus(@PathVariable(name = "status")Status status) {
        return placeRepository.countPlacesByStatus(status);
    }

    @GetMapping("/c/{status}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public Integer countCountriesByStatus(@PathVariable(name = "status")Status status) {
        return placeRepository.countCountriesByStatus(status);
    }

    @GetMapping("/d/{status}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public Integer countDaysNeededByStatus(@PathVariable(name = "status")Status status) {
        return placeRepository.countDaysNeededByStatus(status);
    }
}
