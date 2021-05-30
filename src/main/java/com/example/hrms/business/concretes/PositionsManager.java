package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.PositionService;
import com.example.hrms.core.results.*;
import com.example.hrms.dataAccess.abstracts.PositionDao;
import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsManager implements PositionService {
    private PositionDao positionDao;

    @Autowired
    public PositionsManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }


    @Override
    public DataResult<List<Positions>> getByPositionList() {
        return new SuccessDataResult<List<Positions>>(positionDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result getByPositionSave(Positions positions) {
        if (positionDao.getByPositionName(positions.getPositionName()) != null) {
            return new ErrorResult("Bu pozisyon ismi mevcuttur.");
        }
        positionDao.save(positions);
        return new SuccessResult("Yeni pozisyon eklendi");
    }

    @Override
    public Result getByPositionDelete(String positionName) {
        Positions position = positionDao.findByPositionName(positionName);
        positionDao.delete(position);
        return new SuccessResult("Pozisyon silindi");
    }
}
