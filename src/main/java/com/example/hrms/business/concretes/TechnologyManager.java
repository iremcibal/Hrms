package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.TechnologyDao;
import com.example.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }

    @Override
    public DataResult<List<Technology>> getByTechnologyList() {
        return new SuccessDataResult<List<Technology>>(technologyDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result getByTechnologySave(Technology technology) {
        technologyDao.save(technology);
        return new SuccessResult("Yeni teknoloji kaydedildi");
    }

    @Override
    public Result getByTechnologyDelete(int technologyId) {
        Technology technology = technologyDao.getByTechnologyId(technologyId);
        technologyDao.delete(technology);
        return new SuccessResult("Teknoloji silindi");
    }

    @Override
    public DataResult<List<Technology>> getByCandidatesId(int id) {
        return new SuccessDataResult<List<Technology>>(technologyDao.getByCandidatesId(id));
    }

    @Override
    public DataResult<List<Technology>> getByCandidatesIdAndStatusTrue(int id) {
        return new SuccessDataResult<List<Technology>>(technologyDao.getByCandidatesIdAndStatusTrue(id));
    }

    @Override
    public DataResult<List<Technology>> getByCandidatesIdAndStatusFalse(int id) {
        return new SuccessDataResult<List<Technology>>(technologyDao.getByCandidatesIdAndStatusFalse(id));
    }

}
