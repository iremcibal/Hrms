package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
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
    public Result getByCandidateForRegister(CandidateForRegisterDto candidateForRegisterDto) {
        Candidates candidates = modelMapper.map(candidateForRegisterDto,Candidates.class);

        return this.candidateService.addByCandidateSave(candidates);
    }

    @Override
    public DataResult<Company> getByCompanyForRegister(CompanyForRegisterDto companyForRegisterDto) {
        Company company = modelMapper.map(companyForRegisterDto,Company.class);

        companyService.getByCompanySave(company);

        return new SuccessDataResult<Company>(company,"Kayıt edildi");
    }

    @Override
    public Result getByUserForLogin(UserForLoginDto userForLoginDto) {
        return null;
    }
}
