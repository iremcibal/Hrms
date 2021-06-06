package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobExperiences;
import com.example.hrms.entities.concretes.University;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperiences>> getByExperiencesList();
    DataResult<List<JobExperiences>> getAllsorted();

    Result getByJobExperiencesSave(JobExperiences jobExperiences);
    Result getByJobExperiencesDelete(int experiencesId);

    DataResult<List<JobExperiences>> getByCandidatesId(int id);



}
