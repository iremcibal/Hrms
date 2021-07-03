package com.example.hrms.api;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    public Result getByJobPostSave(@RequestBody JobPost jobPost){
        return jobPostService.getByJobPostSave(jobPost);
    }

    //İş ilanı
    @GetMapping("/getall")
    public DataResult<List<JobPost>> getJobPostByActiveTrue(){
        return jobPostService.getJobPostByActiveTrue();
    }

    //Onaylanmış iş ilanları listesi
    @GetMapping("/getByStatusTrue")
    public DataResult<List<JobPost>> getJobPostByStatusTrue(){
        return jobPostService.getJobPostByStatusTrue();
    }
    //Onaylanmamış iş ilanları listesi
    @GetMapping("/getByStatusFalse")
    public DataResult<List<JobPost>> getJobPostByStatusFalse() {
        return jobPostService.getJobPostByStatusFalse();
    }

    //Aktif olan iş ilanlarını sıralama
    @GetMapping("/getByJobPostList")
    public DataResult<List<JobPost>> getByJobPostList(Boolean isActive){
        return jobPostService.getByJobPostList(isActive);
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
    @GetMapping("/getByCompanyIdList")
    public DataResult<List<JobPost>> getByCompany_Id(int companyId){
        return jobPostService.getByCompany_Id(companyId);
    }

    //Aktifliğini değiştirmek
    @GetMapping("/updateActiveJobPost")
    public DataResult<JobPost> updateActiveJobPost(int id, Boolean active){
        return jobPostService.updateActiveJobPost(id,active);
    }

    @GetMapping("/updateStatusJobPost")
    public DataResult<JobPost> updateStatusJobPost(int id) {
        return jobPostService.updateStatusJobPost(id);
    }

    @DeleteMapping("/jobPostDelete{jobPostId}")
    public Result getByJobPostDelete(@PathVariable int jobPostId) {
        return jobPostService.getByJobPostDelete(jobPostId);
    }



}
