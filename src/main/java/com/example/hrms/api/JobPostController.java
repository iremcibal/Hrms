package com.example.hrms.api;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
@RequestMapping("/jobpost")
public class JobPostController {
    private JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    //Kayıt
    @PostMapping("/getByJobPostSave")
    public Result getByJobPostSave(JobPost jobPost){
        return jobPostService.getByJobPostSave(jobPost);
    }

    //Aktif olan iş ilanlarını sıralama
    @GetMapping("/setByJobPostList")
    public DataResult<List<JobPost>> setByJobPostList(Boolean isActive){
        return jobPostService.setByJobPostList(isActive);
    }

    //Tarihe göre sıralama
    @GetMapping("/getByJobPostSort")
    public DataResult<List<JobPost>> getByJobPostSort(){
        return jobPostService.getByJobPostSort();
    }

    //Şirket ismine göre sıralama
    @GetMapping("/getByCompanyNameList")
    public DataResult<List<JobPost>> getByCompanyNameList(String companyName){
        return jobPostService.getByCompanyNameList(companyName);
    }






}
