package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.dtos.CurriculumVitaeDto;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidates>> getByCandidateList();
    Result addByCandidateSave(Candidates candidates);
    DataResult<CurriculumVitaeDto> getCurriculumVitaeById(int id);

    Result getByCandidateDelete(String nationaltyNo);

}
