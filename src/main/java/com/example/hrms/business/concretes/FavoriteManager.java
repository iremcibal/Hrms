package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.FavoriteService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.FavoriteDao;
import com.example.hrms.entities.concretes.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {

    private FavoriteDao favoriteDao;

    public FavoriteManager(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public DataResult<List<Favorite>> getByFavoriteList() {
        return new SuccessDataResult<List<Favorite>>(favoriteDao.findAll(),"Data listelendi");
    }

    @Override
    public Result addByFavorite(Favorite favorite) {
        favoriteDao.save(favorite);
        return new SuccessResult("Data kayıt edildi.");
    }

    @Override
    public Result deleteByFavorite(int favoriteId) {
        Favorite favorite=favoriteDao.getByFavoriteId(favoriteId);
        favoriteDao.delete(favorite);
        return new SuccessResult("Data silindi");
    }

    @Override
    public DataResult<List<Favorite>> getByCandidates_Id(int id) {
        return new SuccessDataResult<List<Favorite>>(favoriteDao.getByCandidates_Id(id),
                "İş arayanlara göre data listelendi");
    }
}
