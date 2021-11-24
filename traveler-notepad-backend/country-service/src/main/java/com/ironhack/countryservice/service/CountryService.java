package com.ironhack.countryservice.service;

import com.ironhack.countryservice.dao.Country;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ironhack.countryservice.repositories.CountryRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        List<Country> allCountries = countryRepository.findAll();
        if (allCountries.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There are no countries to display.");
        }
        return  allCountries;
    }

    public Country getById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country with id "+id+" does not exist."));
        return country;
    }

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
