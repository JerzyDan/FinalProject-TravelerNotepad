package com.ironhack.placeservice.controller;

import com.ironhack.placeservice.dao.Place;
import com.ironhack.placeservice.repository.PlaceRepository;
import com.ironhack.placeservice.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceService placeService;

    @GetMapping
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public List<Place> getPlaces() {
        List<Place> places = placeRepository.findAll();
        if (places.isEmpty()) {
            return null;
        } else {
            return places;
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public Place getPlaceById(@PathVariable(name = "id") Long id) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        return optionalPlace.isPresent() ? optionalPlace.get() : null;
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    public Place store(@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(name = "id")Long id, @RequestBody Place place) {
        placeService.update(id,place);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove (@PathVariable Long id) {
        placeRepository.deleteById(id);
    }
}
