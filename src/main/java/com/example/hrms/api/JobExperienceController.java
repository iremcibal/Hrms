package com.example.hrms.api;


import com.example.hrms.business.abstracts.JobExperienceService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.JobExperiences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/jobexperience")
public class JobExperienceController {
    @Autowired
    private JobExperienceService jobExperienceService;

    @GetMapping("/List")
    DataResult<List<JobExperiences>> getByExperiencesList(){
        return jobExperienceService.getByExperiencesList();

    }
    @GetMapping("/getAllsortedList")
    public DataResult<List<JobExperiences>> getAllsorted(){
        return jobExperienceService.getAllsorted();
    }

    @PostMapping("/save")
    Result getByJobExperiencesSave(@RequestBody JobExperiences jobExperiences){
        return jobExperienceService.getByJobExperiencesSave(jobExperiences);

    }

    @DeleteMapping("/delete{experiencesId}")
    Result getByJobExperiencesDelete(@PathVariable int experiencesId){
        return jobExperienceService.getByJobExperiencesDelete(experiencesId);
    }

}
