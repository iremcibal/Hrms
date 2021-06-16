package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.entities.concretes.JobType;

import java.util.List;

public interface JobTypeService {
    DataResult<List<JobType>> getByJobTypeList();
}
