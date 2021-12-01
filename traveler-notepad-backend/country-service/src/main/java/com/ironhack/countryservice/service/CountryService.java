package com.ironhack.countryservice.service;

import com.ironhack.countryservice.dao.Country;
import com.ironhack.countryservice.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void update(Long id, Country country) {
        Optional<Country> storedCountry = countryRepository.findById(id);
        if (storedCountry.isPresent()) {

            if (country.getName()!=null) {
                try {
                    storedCountry.get().setName(country.getName());
                } catch (Exception e) {
                    throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can not be blank");
                }
            }

            if (country.getArea()!=null) {
                try {
                    storedCountry.get().setArea(country.getArea());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Area can not be blank");
                }
            }

            if (country.getClimate()!=null) {
                try {
                    storedCountry.get().setClimate(country.getClimate());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Climate can not be blank");
                }
            }

            if (country.getOfficialLanguage()!=null) {
                try {
                    storedCountry.get().setOfficialLanguage(country.getOfficialLanguage());
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Official language can not be blank");
                }
            }

            countryRepository.save(country);
        }
    }
}
