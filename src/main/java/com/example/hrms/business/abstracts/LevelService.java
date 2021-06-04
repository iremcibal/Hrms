package com.example.hrms.business.abstracts;


import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Level;
import com.example.hrms.entities.concretes.Technology;

import java.util.List;

public interface LevelService {

    DataResult<List<Level>> getByLevelList();
    Result getByLevelSave(Level level);
    Result getByLevelDelete(int levelId);


}
