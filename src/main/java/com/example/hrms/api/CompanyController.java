package com.example.hrms.api;


import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/employers")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getByCompanyList")
    public DataResult<List<Company>> getByCompanyList(){
        return companyService.getByCompanyList();
    }


    @PostMapping("/addCompany")
    public Result getByCompanySave(@RequestBody Company company){
        return companyService.getByCompanySave(company);
    }

    @DeleteMapping("/delete/{companyName}")
    public Result getByCompanyDelete(@PathVariable String companyName){
        return companyService.getByCompanyDelete(companyName);
    }



}
