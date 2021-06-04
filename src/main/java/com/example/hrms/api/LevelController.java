package com.example.hrms.api;


import com.example.hrms.business.abstracts.LevelService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @GetMapping("/getByLevelList")
    public DataResult<List<Level>> getByLevelList() {
        return levelService.getByLevelList();
    }

    @PostMapping("/getByLevelSave")
    public Result getByLevelSave(@RequestBody Level level) {
        return levelService.getByLevelSave(level);
    }

    @DeleteMapping("/getByLevelDelete{levelId}")
    public Result getByLevelDelete(@PathVariable int levelId) {
        return levelService.getByLevelDelete(levelId);
    }

}
