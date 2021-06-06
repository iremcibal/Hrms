package com.example.hrms.business.abstracts;


import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.CvDetails;
import com.example.hrms.entities.concretes.dtos.CurriculumVitaeDto;

import java.util.List;

public interface CvDetailService {
    DataResult<List<CvDetails>> getAll();
    Result getByCvDetailSave(CvDetails cvDetails);
    Result getByCurriculumVitaeDelete(int cv_id);

    DataResult<List<CvDetails>> getByCandidatesId(int id);
}
