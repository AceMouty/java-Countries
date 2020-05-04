package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    // localhost:2019/countries/all
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getCountries(){

            return new ResponseEntity<>(CountriesApplication.mainCountryList.countryList, HttpStatus.OK);
    }


}
