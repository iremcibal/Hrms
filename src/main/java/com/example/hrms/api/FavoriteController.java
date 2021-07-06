package com.example.hrms.api;

import com.example.hrms.business.abstracts.FavoriteService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/getByFavoriteSave")
    public Result getByFavoriteSave(@RequestBody Favorite favorite) {
        return favoriteService.getByFavoriteSave(favorite);
    }

    @DeleteMapping("/getByFavoriteDelete{favoriteId}")
    public Result getByFavoriteDelete(@RequestParam int favoriteId) {
        return favoriteService.getByFavoriteDelete(favoriteId);
    }

    @GetMapping("/getByCandidateIdFavList")
    public DataResult<List<Favorite>> getByCandidates_Id(@RequestParam int id) {
        return favoriteService.getByCandidates_Id(id);
    }
}
