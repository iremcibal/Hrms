package com.example.hrms.api;


import com.example.hrms.business.abstracts.UniversityService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;


    @GetMapping("/getByUniversityList")
    public DataResult<List<University>> getByUniversityList() {
        return universityService.getByUniversityList();
    }


    @GetMapping("/getAllsortedList")
    public DataResult<List<University>> getAllsorted() {
        return universityService.getAllsorted();
    }

    @PostMapping("/save")
    public Result getByUniversitySave(@RequestBody University university){
        return universityService.getByUniversitySave(university);

    }

    @DeleteMapping("/delete{universityId}")
    public Result getByUniversityDelete(@PathVariable int universityId){
        return universityService.getByUniversityDelete(universityId);
    }


}
