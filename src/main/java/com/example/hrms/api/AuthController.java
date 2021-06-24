package com.example.hrms.api;


import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.dtos.authDtos.CandidateForRegisterDto;
import com.example.hrms.entities.concretes.dtos.authDtos.CompanyForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("AuthController")
public class AuthController {
    private AuthService authService;
    private CandidateService candidateService;
    private CompanyService companyService;

    @Autowired
    public AuthController(AuthService authService, CandidateService candidateService, CompanyService companyService) {
        this.authService = authService;
        this.candidateService = candidateService;
        this.companyService = companyService;
    }

    @PostMapping("/candidateForRegisterDto")
    public Result getByCandidateForRegister(@Valid @RequestBody CandidateForRegisterDto candidateForRegisterDto) {
        return authService.getByCandidateForRegister(candidateForRegisterDto);

    }

    @PostMapping("/companyForRegisterDto")
    public DataResult<Company> getByCompanyForRegister(@RequestBody CompanyForRegisterDto companyForRegisterDto) {
        return authService.getByCompanyForRegister(companyForRegisterDto);
    }





}