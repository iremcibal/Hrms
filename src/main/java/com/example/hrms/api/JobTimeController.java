package com.example.hrms.api;


import com.example.hrms.business.abstracts.JobTimeService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.entities.concretes.JobTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/jobtime")
public class JobTimeController {
    private JobTimeService jobTimeService;

    @Autowired
    public JobTimeController(JobTimeService jobTimeService) {
        this.jobTimeService = jobTimeService;
    }

    @GetMapping("/timeList")
    public DataResult<List<JobTime>> getByJobTimeList(){
        return jobTimeService.getByJobTimeList();
    }


}
