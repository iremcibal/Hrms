package com.example.hrms.business.abstracts;


import com.example.hrms.core.results.Result;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Company;

import com.example.hrms.entities.concretes.dtos.authDtos.CandidateForRegisterDto;
import com.example.hrms.entities.concretes.dtos.authDtos.CompanyForRegisterDto;
import com.example.hrms.entities.concretes.dtos.authDtos.UserForLoginDto;

public interface AuthService {

    Result addByCandidateForRegister(CandidateForRegisterDto candidateForRegisterDto);
    Result addByCompanyForRegister(CompanyForRegisterDto companyForRegisterDto);


    Result getByUserForLogin(UserForLoginDto userForLoginDto);





}
