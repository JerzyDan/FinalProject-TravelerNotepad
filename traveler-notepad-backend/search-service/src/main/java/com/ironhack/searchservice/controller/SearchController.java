package com.ironhack.searchservice.controller;

import com.ironhack.searchservice.dao.Place;
import com.ironhack.searchservice.enums.Status;
import com.ironhack.searchservice.repositories.CountryRepository;
import com.ironhack.searchservice.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/{name}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Place> getPlaceByName(@PathVariable(name = "name") String name) {
        Optional<Place> foundPlace = placeRepository.findByName(name);
        if (foundPlace.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no place to display");
        }
        return foundPlace;
    }

    @GetMapping("/c/{city}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getPlacesByCity(@PathVariable(name = "city") String city) {
        List<Place> foundPlaces = placeRepository.findByCity(city);
        return foundPlaces;
    }

    @GetMapping("/s/{status}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getPlacesByStatus(@PathVariable(name = "status")Status status) {
        List<Place> foundPlaces = placeRepository.findByStatus(status);
        return foundPlaces;
    }

    @GetMapping("/d/{days}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getPlacesByDays(@PathVariable(name = "days") Integer days) {
        List<Place> foundPlaces = placeRepository.findByDaysNeededLessThanEqual(days);
        return foundPlaces;
    }

    @GetMapping("/ca/{id}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getPlacesByCountry(@PathVariable(name = "id") Long id) {
        List<Place> foundPlaces = placeRepository.findByCountryId(id);
        return foundPlaces;
    }

}
