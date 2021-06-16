package com.example.hrms.api;

import com.example.hrms.business.abstracts.JobTypeService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.entities.concretes.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jobtype")
public class JobTypeController {
    @Autowired
    private JobTypeService jobTypeService;

    @GetMapping("/typeList")
    public DataResult<List<JobType>> getByJobTypeList(){
        return jobTypeService.getByJobTypeList();
    }

}
