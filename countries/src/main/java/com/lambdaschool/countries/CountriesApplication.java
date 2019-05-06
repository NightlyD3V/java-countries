package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {

    static countryList ourCountries;
    public static void main(String[] args)
    {
        ourCountries = new countryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
