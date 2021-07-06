package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteDao extends JpaRepository<Favorite,Integer> {
    Favorite getByFavoriteId(int favoriteId);

    List<Favorite> getByCandidates_Id(int id);

}
