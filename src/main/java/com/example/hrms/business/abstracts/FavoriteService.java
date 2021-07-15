package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Favorite;

import java.util.List;

public interface FavoriteService {
    DataResult<List<Favorite>> getByFavoriteList();
    Result addByFavorite(Favorite favorite);
    Result deleteByFavorite(int favoriteId);

    DataResult<List<Favorite>> getByCandidates_Id(int id);


}
