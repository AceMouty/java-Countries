package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {

    // localhost:2019/age/25 -> return countries who's median age greater or equal to a number passed
    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getMedianAges(@PathVariable int age){
        ArrayList<Country> data = CountriesApplication.mainCountryList.getCountriesByAge(age);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    // localhost:2019/age/min -> get the country with the smallest median age
    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getMinAge(){
        Country data = CountriesApplication.mainCountryList.getMinAge();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    // localhost:2019/age/max -> get the country with the max median age
    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getMaxAge(){
        Country data = CountriesApplication.mainCountryList.getMaxAge();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
