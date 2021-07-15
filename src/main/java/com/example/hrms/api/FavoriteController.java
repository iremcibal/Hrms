package com.example.hrms.api;

import com.example.hrms.business.abstracts.FavoriteService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/getByFavoriteList")
    public DataResult<List<Favorite>> getByFavoriteList() {
        return favoriteService.getByFavoriteList();
    }

    @PostMapping("/addFavorite")
    public Result addByFavorite(@RequestBody Favorite favorite) {
        return favoriteService.addByFavorite(favorite);
    }

    @DeleteMapping("/deleteFavorite{favoriteId}")
    public Result deleteFavorite(@RequestParam int favoriteId) {
        return favoriteService.deleteByFavorite(favoriteId);
    }

    @GetMapping("/getByCandidateIdFavList")
    public DataResult<List<Favorite>> getByCandidates_Id(@RequestParam int id) {
        return favoriteService.getByCandidates_Id(id);
    }
}
