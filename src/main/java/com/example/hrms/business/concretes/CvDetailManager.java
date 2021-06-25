package com.example.hrms.business.concretes;


import com.example.hrms.business.abstracts.CvDetailService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvDetailDao;
import com.example.hrms.entities.concretes.CvDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvDetailManager implements CvDetailService {

    private CvDetailDao cvDetailDao;

    public CvDetailManager(CvDetailDao cvDetailDao) {
        this.cvDetailDao = cvDetailDao;
    }


    @Override
    public DataResult<List<CvDetails>> getAll() {
        return new SuccessDataResult<List<CvDetails>>(cvDetailDao.findAll(), "Data listelendi.");
    }

    public Result getByCvDetailSave(CvDetails cvDetails){
        cvDetailDao.save(cvDetails);
        return new SuccessResult("Data kaydedildi.");
    }

    @Override
    public Result getByCurriculumVitaeDelete(int cv_id) {
        return null;
    }

    @Override
    public DataResult<List<CvDetails>> getByCandidatesId(int candidatesId) {
        return new SuccessDataResult<List<CvDetails>>(cvDetailDao.getByCandidatesId(candidatesId));
    }


}
