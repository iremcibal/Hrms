package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.abstracts.EmailService;
import com.example.hrms.core.results.*;
import com.example.hrms.dataAccess.abstracts.CompanyDao;
import com.example.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyManager implements CompanyService {
    private CompanyDao companyDao;
    private EmailService emailService;


    @Autowired
    public CompanyManager(CompanyDao companyDao, EmailService emailService) {
        this.companyDao = companyDao;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Company>> getByCompanyList() {
        return new SuccessDataResult<List<Company>>(companyDao.findAll(),"Data listelendi.");
    }


    @Override
    public Result getByCompanySave(Company company) {
        String[] email = company.getEmail().split("@");
        if(company.getEmail().isEmpty() || company.getPassword().isEmpty() || company.getCompanyName().isEmpty()
        || company.getTelePhone().isEmpty() || company.getWebSite().isEmpty() ){
            return new ErrorResult("Lütfen bilgileri eksiksiz giriniz.");
        }
        else if(companyDao.getByEmail(company.getEmail())!=null){
            return new ErrorResult("Bu email ile kayıt mevcut.");
        }
        else if(!company.getWebSite().contains(email[1])){
            return new ErrorResult("Şirket adresiniz ile kayıt olunuz.");
        }

        emailService.sendLinkForMail(company.getEmail());
        System.out.println("--------------------------");
        emailService.activeLinkForMail(company.getEmail());
        System.out.println("--------------------------");
        System.out.println("Sistem personeli tarafından onay verilmiştir.");
        companyDao.save(company);
        return new SuccessResult("Yeni üye kaydedildi.");
    }

    @Override
    public Result getByCompanyDelete(String companyName) {
        Company company = companyDao.findByCompanyName(companyName);
        companyDao.delete(company);
        return new SuccessResult("Kayıt silindi.");
    }


}
