package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/data")
public class CountryController
{
    // localhost:7000/data/names/all
    @RequestMapping(value = "/names/all")
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCountries.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCountries.countryList, HttpStatus.OK);
    }

    // localhost:7000/data/names/start/s
    @GetMapping(value = "/names/start/{letter}")
    public ResponseEntity<?> getCountryLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountries
                .findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnCountry.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:7000/data/names/size/10
    @GetMapping(value = "/names/size/{number}")
    public ResponseEntity<?> getCountryNumber(@PathVariable int number)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountries.findCountries(c -> c.getName().length() >= number);
        rtnCountry.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:7000/data/population/size/10
    @GetMapping(value = "/population/size/{people}")
    public ResponseEntity<?> getPopulationSize(@PathVariable int people)
    {
        ArrayList<Country> rtnCountry = CountriesApplication.ourCountries.findCountries(c -> c.getPopulation() >= people);
        rtnCountry.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    // localhost:7000/data/population/min
    @GetMapping(value = "/population/min")
    public ResponseEntity<?> getMinPopulation()
    {
        countryList rtnCountry = CountriesApplication.ourCountries;
        rtnCountry.countryList.sort(Comparator.comparingInt(Country::getPopulation));
        return new ResponseEntity<>(rtnCountry.countryList.get(0), HttpStatus.OK);
    }

    // localhost:7000/data/population/max
    @GetMapping(value = "/population/max")
    public ResponseEntity<?> getMaxPopulation()
    {
        countryList rtnCountry = CountriesApplication.ourCountries;
        rtnCountry.countryList.sort(Comparator.comparingInt(Country::getPopulation));
        return new ResponseEntity<>(rtnCountry.countryList.get(rtnCountry.countryList.size() - 1), HttpStatus.OK);
    }

    // STRETCH
    // localhost:7000/data/median/{country}
    @GetMapping(value="/median")
    public ResponseEntity<?> getMedianAge()
    {
        countryList rtnCountry = CountriesApplication.ourCountries;
        rtnCountry.countryList.sort(Comparator.comparingInt(Country::getMedianAge));
        return new ResponseEntity<>(rtnCountry.countryList.get(rtnCountry.countryList.size() / 2 ),HttpStatus.OK);
    }
}

