package com.example.hrms.api;


import com.example.hrms.business.abstracts.CvDetailService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.CvDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cv")
public class CvDetailController {

    private CvDetailService cvDetailService;

    @Autowired
    public CvDetailController(CvDetailService cvDetailService) {
        this.cvDetailService = cvDetailService;
    }


    @GetMapping("/list")
    DataResult<List<CvDetails>> getAll(){
        return cvDetailService.getAll();
    }

    @PostMapping("/add")
    public Result getByCvDetailSave(@RequestBody CvDetails cvDetails){
        return cvDetailService.getByCvDetailSave(cvDetails);
    }



}
