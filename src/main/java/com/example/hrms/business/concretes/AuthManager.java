package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.dtos.authDtos.CandidateForRegisterDto;
import com.example.hrms.entities.concretes.dtos.authDtos.CompanyForRegisterDto;
import com.example.hrms.entities.concretes.dtos.authDtos.UserForLoginDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private CandidateService candidateService;
    private CompanyService companyService;
    private ModelMapper modelMapper;


    @Autowired
    public AuthManager(CandidateService candidateService, CompanyService companyService, ModelMapper modelMapper) {
        this.candidateService = candidateService;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result addByCandidateForRegister(CandidateForRegisterDto candidateForRegisterDto) {
        Candidates candidates = modelMapper.map(candidateForRegisterDto,Candidates.class);

        return this.candidateService.addByCandidateSave(candidates);
    }

    @Override
    public Result addByCompanyForRegister(CompanyForRegisterDto companyForRegisterDto) {
        Company company = modelMapper.map(companyForRegisterDto,Company.class);

        return this.companyService.getByCompanySave(company);
    }

    @Override
    public Result getByUserForLogin(UserForLoginDto userForLoginDto) {
        return null;
    }
}
