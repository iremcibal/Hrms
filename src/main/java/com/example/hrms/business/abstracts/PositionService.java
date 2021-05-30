package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Positions;

import java.util.List;

public interface PositionService {
    DataResult<List<Positions>> getByPositionList();
    Result getByPositionSave(Positions positions);
    Result getByPositionDelete(String positionName);

}
