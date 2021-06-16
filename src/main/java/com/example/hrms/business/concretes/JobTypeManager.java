package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTypeService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.JobTypeDao;
import com.example.hrms.entities.concretes.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeManager implements JobTypeService {
    private JobTypeDao jobTypeDao;

    @Autowired
    public JobTypeManager(JobTypeDao jobTypeDao) {
        this.jobTypeDao = jobTypeDao;
    }

    @Override
    public DataResult<List<JobType>> getByJobTypeList() {
        return new SuccessDataResult<List<JobType>>(jobTypeDao.findAll(),"Data listelendi");
    }
}
