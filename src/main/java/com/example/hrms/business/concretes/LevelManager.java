package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LevelService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LevelDao;
import com.example.hrms.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelManager implements LevelService {
    @Autowired
    private LevelDao levelDao;

    @Override
    public DataResult<List<Level>> getByLevelList() {
        return new SuccessDataResult<List<Level>>(levelDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result getByLevelSave(Level level) {
        levelDao.save(level);
        return new SuccessResult("Data kaydedildi.");
    }

    @Override
    public Result getByLevelDelete(int levelId) {
        Level level = levelDao.getByLevelId(levelId);
        levelDao.delete(level);
        return new SuccessResult("Data silindi.");
    }
}
