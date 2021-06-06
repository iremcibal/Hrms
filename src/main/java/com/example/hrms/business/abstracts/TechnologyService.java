package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.Technology;

import java.util.List;

public interface TechnologyService {

    DataResult<List<Technology>> getByTechnologyList();
    Result getByTechnologySave(Technology technology);
    Result getByTechnologyDelete(int technologyId);

    DataResult<List<Technology>> getByCandidatesId(int id);


}
