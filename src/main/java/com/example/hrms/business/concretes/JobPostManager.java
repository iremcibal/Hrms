package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.results.*;
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
    public DataResult<List<JobPost>> getJobPostByActiveTrue() {
        return new SuccessDataResult<List<JobPost>>(jobPostDao.getByIsActiveTrue(),"İş ilanları");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByStatusTrue() {
        return new SuccessDataResult<List<JobPost>>(jobPostDao.getByStatusTrue(),"Onaylanmış iş ilanları listesi");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByStatusFalse() {
        return new SuccessDataResult<List<JobPost>>(jobPostDao.getByStatusFalse(),"Onaylanmamış iş ilanları");
    }

    @Override
    public DataResult<List<JobPost>> getByJobPostList(Boolean isActive) {
        return new DataResult<List<JobPost>>(jobPostDao.getByIsActive(isActive),true,"Aktif iş ilanları");
    }

    @Override
    public DataResult<List<JobPost>> getByJobPostSort() {
        Sort sort = Sort.by(Sort.Direction.ASC,"createdAt");
        return new SuccessDataResult<List<JobPost>>(jobPostDao.findAll(sort),"Tarihe göre listelendi.");
    }

    @Override
    public DataResult<List<JobPost>> getByCompanyNameList(String companyName) {

        return new SuccessDataResult<List<JobPost>>(jobPostDao.getByCompany_CompanyName(companyName), "Data Listelendi.");
    }

    @Override
    public DataResult<List<JobPost>> getByCompany_Id(int companyId) {
        return new SuccessDataResult<List<JobPost>>(jobPostDao.getByCompany_Id(companyId),"Data listelendi.");
    }

    @Override
    public DataResult<JobPost> updateActiveJobPost(int id, Boolean status) {
        JobPost jobPost = this.jobPostDao.getByJobPostId(id);
        jobPost.setActive(status);
        jobPostDao.save(jobPost);
        return new SuccessDataResult<JobPost>(jobPost,"İlanınızın aktiflik durumu değişmiştir.");

    }

    @Override
    public DataResult<JobPost> updateStatusJobPost(int id) {
        JobPost jobPost = this.jobPostDao.getByJobPostId(id);
        jobPost.setStatus(true);
        jobPostDao.save(jobPost);
        return new SuccessDataResult<JobPost>(jobPost,"Onay değişikliği");
    }

    @Override
    public Result getByJobPostDelete(int jobPostId) {
        JobPost jobPost = jobPostDao.getByJobPostId(jobPostId);
        jobPostDao.delete(jobPost);
        return new SuccessResult("Silindi");
    }


}
