package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.abstracts.EmailService;
import com.example.hrms.core.abstracts.UserCheckService;
import com.example.hrms.core.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserCheckService userCheckService;
    private EmailService emailService;

    @Autowired
    public CandidatesManager(CandidateDao candidateDao, UserCheckService userCheckService, EmailService emailService) {
        this.candidateDao = candidateDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Candidates>> getByCandidateList() {
        return new SuccessDataResult<List<Candidates>>(candidateDao.findAll(),"Data listelendi");
    }

    @Override
    public Result getByCandidateSave(Candidates candidates) {
        if( candidates.getName().isEmpty() || candidates.getLastName().isEmpty() || candidates.getNationaltyNo().isEmpty()
                || String.valueOf(candidates.getBirthDate()).isEmpty() || candidates.getEmail().isEmpty()
                || candidates.getPassword().isEmpty()){
            return new ErrorResult("Lütfen bilgileri eksiksiz giriniz.");
        }
        else if(!this.userCheckService.CheckIfRealPerson(candidates)){
            return new ErrorResult("Gerçek kimliğinizle giriş yapınız.");
        }
        else if(this.candidateDao.getByEmail(candidates.getEmail())!=null || this.candidateDao.getByNationaltyNo(candidates.getNationaltyNo())!=null){
            return new ErrorResult("Daha önce kullanılmamış bilgiler giriniz.");
        }

        this.emailService.sendLinkForMail(candidates.getEmail());
        System.out.println("----------------------------");
        this.emailService.activeLinkForMail(candidates.getEmail());
        candidateDao.save(candidates);
        return new Result(true,"Yeni üye kaydedildi.");

    }

    @Override
    public Result getByCandidateDelete(String nationaltyNo) {
        Candidates candidates = candidateDao.findByNationaltyNo(nationaltyNo);
        candidateDao.delete(candidates);
        return new SuccessResult("Üye silindi.");
    }


}
