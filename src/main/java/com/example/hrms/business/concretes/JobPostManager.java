package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostDao;
import com.example.hrms.entities.concretes.JobPost;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostManager implements JobPostService {
    private JobPostDao jobPostDao;

    public JobPostManager(JobPostDao jobPostDao) {
        this.jobPostDao = jobPostDao;
    }

    @Override
    public Result getByJobPostSave(JobPost jobPost) {
        jobPostDao.save(jobPost);
        return new SuccessResult("Yeni iş ilanı eklenmiştir.");

    }

    @Override
    public DataResult<List<JobPost>> setByJobPostList(Boolean isActive) {
        return new SuccessDataResult<List<JobPost>>(jobPostDao.findAll(),"Aktif iş ilanları");
    }

    @Override
    public DataResult<List<JobPost>> getByJobPostSort() {
        Sort sort = Sort.by(Sort.Direction.ASC,"createdAt");
        return new SuccessDataResult<List<JobPost>>(jobPostDao.findAll(sort),"Tarihe göre listelendi.");
    }

    @Override
    public DataResult<List<JobPost>> getByCompanyNameList(String companyName) {

        return new SuccessDataResult<List<JobPost>>(jobPostDao.getByCompany_CompanyName(companyName),"Data Listelendi.");
    }
}
