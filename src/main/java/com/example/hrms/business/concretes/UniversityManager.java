package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UniversityService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UniversityDao;
import com.example.hrms.entities.concretes.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UniversityManager implements UniversityService {
    @Autowired
    private UniversityDao universityDao;


    @Override
    public DataResult<List<University>> getByUniversityList() {
        return new SuccessDataResult<List<University>>(universityDao.findAll(),"Data Listelendi.");
    }

    @Override
    public DataResult<List<University>> getAllsorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"finishAt");
        return new SuccessDataResult<List<University>>(universityDao.findAll(sort),"Data listelendi.");
    }

    @Override
    public Result getByUniversitySave(University university) {
        universityDao.save(university);
        return new SuccessResult("Data kaydedildi.");
    }

    @Override
    public Result getByUniversityDelete(int universityId) {
        University university = universityDao.getByUniversityId(universityId);
        universityDao.delete(university);
        return new SuccessResult("Data silindi.");
    }

    @Override
    public DataResult<List<University>> getByCandidatesId(int id) {
        return new SuccessDataResult<List<University>>(this.universityDao.getByCandidatesId(id));
    }

}
