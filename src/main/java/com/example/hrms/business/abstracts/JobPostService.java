package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobPost;

import java.util.List;

public interface JobPostService {
    Result getByJobPostSave(JobPost jobPost);
    DataResult<List<JobPost>> getByJobPostList(Boolean isActive);
    DataResult<List<JobPost>> getByJobPostSort();
    DataResult<List<JobPost>> getByCompanyNameList(String companyName);

    DataResult<JobPost> updateStatusJobPost(int id,Boolean status);


}
