package com.example.hrms.business.abstracts;


import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    DataResult<List<Education>> getByEducationList();
    Result getByEducationSave(Education education);
    Result getByEducationDelete(int educationId);


}
