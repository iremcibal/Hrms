package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getByCityList() {
        return new SuccessDataResult<List<City>>(cityDao.findAll(),"Data listelendi.");
    }

    @Override
    public Result getByCitySave(City city) {
        cityDao.save(city);
        return new SuccessResult("Data kaydedildi.");
    }


}
