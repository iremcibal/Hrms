package com.example.hrms.api;


import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/city")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cityList")
    public DataResult<List<City>> getByCityList(){
        return cityService.getByCityList();
    }

    @PostMapping("/cityPost")
    public Result getByCitySave(@RequestBody City city) {
        return cityService.getByCitySave(city);
    }

}
