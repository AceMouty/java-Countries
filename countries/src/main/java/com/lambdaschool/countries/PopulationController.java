package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {

    // localhost:2019/population/size/1000000000 -> return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(@PathVariable int number){
        ArrayList<Country> countriesList = new ArrayList<>(CountryList.countryList);
        ArrayList<Country> data = CountriesApplication.mainCountryList.filterByPopulation(countriesList, number);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
