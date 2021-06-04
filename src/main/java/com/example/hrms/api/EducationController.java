package com.example.hrms.api;


import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/education")
public class EducationController {
    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getByEducationList")
    public DataResult<List<Education>> getByEducationList() {
        return educationService.getByEducationList();

    }
    @PostMapping("/getByEducationSave")
    public Result getByEducationSave(@RequestBody Education education){
        return educationService.getByEducationSave(education);
    }

    @DeleteMapping("getByEducationDelete{educationId}")
    public Result getByEducationDelete(@PathVariable int educationId) {
        return educationService.getByEducationDelete(educationId);
    }


}
