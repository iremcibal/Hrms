package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }


    @Override
    public DataResult<List<Education>> getByEducationList() {
        return new SuccessDataResult<List<Education>>(educationDao.findAll(),"Data Listelendi.");
    }

    @Override
    public Result getByEducationSave(Education education) {
        educationDao.save(education);
        return new SuccessResult("Yeni Eğitim Seviyesi Eklendi");
    }

    @Override
    public Result getByEducationDelete(int educationId) {
        Education education = educationDao.getByEducationId(educationId);
        educationDao.delete(education);
        return new SuccessResult("Eğitim seviyesi silindi.");
    }
}
