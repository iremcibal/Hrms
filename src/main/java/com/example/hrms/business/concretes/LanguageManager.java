package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageDao;
import com.example.hrms.entities.concretes.ForeignLanguage;
import com.example.hrms.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    @Autowired
    private LanguageDao languageDao;

    @Override
    public DataResult<List<ForeignLanguage>> getByForeignLanguageList() {
        return new SuccessDataResult<List<ForeignLanguage>>(languageDao.findAll(),"Data listelendi");
    }

    @Override
    public Result getByForeignLanguageSave(ForeignLanguage foreignLanguage) {
        languageDao.save(foreignLanguage);
        return new SuccessResult("Data eklendi.");
    }

    @Override
    public Result getByForeignLanguageDelete(int languageId) {
        ForeignLanguage foreignLanguage = languageDao.getByLanguageId(languageId);
        languageDao.delete(foreignLanguage);
        return new SuccessResult("Data silindi.");
    }

    @Override
    public DataResult<List<ForeignLanguage>> getByCandidateId(int id) {
        return new SuccessDataResult<List<ForeignLanguage>>(languageDao.getByCandidatesId(id));
    }
}
