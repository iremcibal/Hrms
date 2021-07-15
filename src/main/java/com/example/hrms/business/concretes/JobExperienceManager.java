package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobExperienceDao;
import com.example.hrms.entities.concretes.JobExperiences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    @Autowired
    private JobExperienceDao jobExperienceDao;


    @Override
    public DataResult<List<JobExperiences>> getByExperiencesList() {
        return new SuccessDataResult<>(jobExperienceDao.findAll(),"Data listelendi.");
    }

    @Override
    public DataResult<List<JobExperiences>> getAllsorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"finishAt");
        return new SuccessDataResult<List<JobExperiences>>(jobExperienceDao.findAll(sort),"Data Listelendi");
    }

    @Override
    public Result getByJobExperiencesSave(JobExperiences jobExperiences) {
        jobExperienceDao.save(jobExperiences);
        return new SuccessResult("Data kaydedildi.");
    }

    @Override
    public Result getByJobExperiencesDelete(int experiencesId) {
        JobExperiences jobExperiences = jobExperienceDao.getByExperiencesId(experiencesId);
        jobExperienceDao.delete(jobExperiences);
        return new SuccessResult("Data silindi.");
    }

    @Override
    public DataResult<List<JobExperiences>> getByCandidatesId(int id) {
        return new SuccessDataResult<List<JobExperiences>>(jobExperienceDao.getByCandidatesId(id));
    }

    @Override
    public DataResult<List<JobExperiences>> getByCandidatesIdAndStatusTrue(int id) {
        return new SuccessDataResult<List<JobExperiences>>(jobExperienceDao.getByCandidatesIdAndStatusTrue(id));
    }

    @Override
    public DataResult<List<JobExperiences>> getByCandidatesIdAndStatusFalse(int id) {
        return new SuccessDataResult<List<JobExperiences>>(jobExperienceDao.getByCandidatesIdAndStatusFalse(id));
    }


}
