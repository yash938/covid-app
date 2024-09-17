package com.covid.app.covid_app.controller;

import com.covid.app.covid_app.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covidCases")
public class covidController {

@Autowired
CovidDataService covidDataService;
@GetMapping("/covid-data/{city}")
     public String getData(@PathVariable String city){
    Integer dataService = covidDataService.getDataService(city);
    return "Covid active cases is "+city+ " = "+dataService ;
     }
}
