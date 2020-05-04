package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController {

    // localhost:2019/names/all
    @GetMapping( value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllNames(){
        ArrayList<Country> data = CountriesApplication.mainCountryList.sortedNames();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    // localhost:2019/names/start/a
    @GetMapping( value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getNamesByLetter(@PathVariable char letter){
        ArrayList<Country> list = new ArrayList<>(CountryList.countryList);
        ArrayList<Country> data = CountriesApplication.mainCountryList.getNamesByLetter(list, letter);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    // localhost:2019/names/size/20 -> return names with a length equal to or longer than the name provided
    @GetMapping(value = "/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getNamesOfXSize(@PathVariable int number){
        ArrayList<Country> list = new ArrayList<>(CountryList.countryList);
        ArrayList<Country> data = CountriesApplication.mainCountryList.getNamesBySize(list, number);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
