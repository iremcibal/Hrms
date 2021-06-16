package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTimeService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.JobTimeDao;
import com.example.hrms.entities.concretes.JobTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTimeManager implements JobTimeService {
    private JobTimeDao jobTimeDao;

    @Autowired
    public JobTimeManager(JobTimeDao jobTimeDao) {
        this.jobTimeDao = jobTimeDao;
    }

    @Override
    public DataResult<List<JobTime>> getByJobTimeList() {
        return new SuccessDataResult<List<JobTime>>(jobTimeDao.findAll(),"Data Listelendi");
    }
}
