package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Company;

import java.util.List;

public interface CompanyService {
    DataResult<List<Company>> getByCompanyList();
    Result getByCompanySave(Company company);
    Result getByCompanyDelete(String companyName);

}
