package com.ironhack.countryservice.controller;

import com.ironhack.countryservice.dao.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ironhack.countryservice.repositories.CountryRepository;
import com.ironhack.countryservice.service.CountryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Country getCountryById(@PathVariable(name = "id")Long id) {
        Optional<Country> optionalCountry = countryRepository.findById(id);
        return optionalCountry.isPresent() ? optionalCountry.get() : null;
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    public Country store(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(name = "id")Long id, @RequestBody Country country) {
        countryService.update(id,country);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove (@PathVariable Long id) {
        countryRepository.deleteById(id);
    }

}
