package com.ironhack.placeservice.service;

import com.ironhack.placeservice.dao.Place;
import com.ironhack.placeservice.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public void update(Long id, Place place) {
        Optional<Place> storedPlace = placeRepository.findById(id);
        if (storedPlace.isPresent()) {

            if (place.getName()!=null) {
                try {
                    storedPlace.get().setName(place.getName());
                } catch (Exception e) {
                    throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can not be blank");
                }
            }

            if (place.getCity()!=null) {
                try {
                    storedPlace.get().setCity(place.getCity());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "City can not be blank");
                }
            }

            if (place.getCountryId()!=null) {
                try {
                    storedPlace.get().setCountryId(place.getCountryId());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country id can not be blank");
                }
            }

            if (place.getDaysNeeded()!=null) {
                try {
                    storedPlace.get().setDaysNeeded(place.getDaysNeeded());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Number of days can not be blank");
                }
            }

            if(place.getDescription()!=null) {
                try {
                    storedPlace.get().setDescription(place.getDescription());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Description can not be blank");
                }
            }

            if (place.getStatus()!=null) {
                try {
                    storedPlace.get().setStatus(place.getStatus());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status can not be blank");
                }
            }

            placeRepository.save(place);
        }
    }
}
