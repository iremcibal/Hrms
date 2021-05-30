package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Candidates;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidates>> getByCandidateList();
    Result getByCandidateSave(Candidates candidates);
    Result getByCandidateDelete(String nationaltyNo);

}
