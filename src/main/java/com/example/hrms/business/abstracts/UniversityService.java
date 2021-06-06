package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.University;

import java.util.List;

public interface UniversityService {
    DataResult<List<University>> getByUniversityList();

    DataResult<List<University>> getAllsorted();

    Result getByUniversitySave(University university);
    Result getByUniversityDelete(int universityId);

    DataResult<List<University>> getByCandidatesId(int id);

}
