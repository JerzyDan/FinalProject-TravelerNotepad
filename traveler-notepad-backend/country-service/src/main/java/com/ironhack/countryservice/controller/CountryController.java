package com.ironhack.countryservice.controller;

import com.ironhack.countryservice.dao.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ironhack.countryservice.repositories.CountryRepository;
import com.ironhack.countryservice.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    @GetMapping //TODO - not work 500
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")    //TODO - not work 500
    @ResponseStatus(HttpStatus.OK)
    public Country getCountryById(@PathVariable(name = "id")Long id) {
        return countryService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Country store(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("/{id}")    //TODO - not work 500
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(name = "id")Long id, @RequestBody Country country) {
        countryService.update(id,country);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {
        countryRepository.deleteById(id);
    }

}
