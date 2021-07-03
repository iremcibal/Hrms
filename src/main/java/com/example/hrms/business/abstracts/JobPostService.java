package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobPost;

import java.util.List;

public interface JobPostService {
    Result getByJobPostSave(JobPost jobPost);
    DataResult<List<JobPost>> getJobPostByActiveTrue();

    DataResult<List<JobPost>> getJobPostByStatusTrue();
    DataResult<List<JobPost>> getJobPostByStatusFalse();

    DataResult<List<JobPost>> getByJobPostList(Boolean isActive);
    DataResult<List<JobPost>> getByJobPostSort();
    DataResult<List<JobPost>> getByCompanyNameList(String companyName);
    DataResult<List<JobPost>> getByCompany_Id(int companyId);


    DataResult<JobPost> updateActiveJobPost(int id,Boolean status);
    DataResult<JobPost> updateStatusJobPost(int id);

    Result getByJobPostDelete(int jobPostId);

}
