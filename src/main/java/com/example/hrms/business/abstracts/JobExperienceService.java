package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobExperiences;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperiences>> getByExperiencesList();
    DataResult<List<JobExperiences>> getAllsorted();

    Result getByJobExperiencesSave(JobExperiences jobExperiences);
    Result getByJobExperiencesDelete(int experiencesId);

    DataResult<List<JobExperiences>> getByCandidatesId(int id);

    DataResult<List<JobExperiences>> getByCandidatesIdAndStatusTrue(int id);
    DataResult<List<JobExperiences>> getByCandidatesIdAndStatusFalse(int id);

}
