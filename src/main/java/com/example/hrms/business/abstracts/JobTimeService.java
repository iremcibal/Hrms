package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.entities.concretes.JobTime;

import java.util.List;

public interface JobTimeService {

    DataResult<List<JobTime>> getByJobTimeList();
}
