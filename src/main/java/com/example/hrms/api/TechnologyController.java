package com.example.hrms.api;

import com.example.hrms.business.abstracts.TechnologyService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/getByTechnologyList")
    public DataResult<List<Technology>> getByTechnologyList() {
        return technologyService.getByTechnologyList();
    }

    @PostMapping("/getByTechnologySave")
    public Result getByTechnologySave(@RequestBody Technology technology) {
        return technologyService.getByTechnologySave(technology);
    }

    @DeleteMapping("/getByTechnologyDelete{technologyId}")
    public Result getByTechnologyDelete(@PathVariable int technologyId) {
        return technologyService.getByTechnologyDelete(technologyId);
    }

}
