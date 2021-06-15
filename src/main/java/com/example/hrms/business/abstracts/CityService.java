package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getByCityList();
    Result getByCitySave(City city);

}
