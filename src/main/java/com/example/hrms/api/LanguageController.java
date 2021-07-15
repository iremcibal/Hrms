package com.example.hrms.api;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/getByForeignLanguageList")
    public DataResult<List<ForeignLanguage>> getByForeignLanguageList() {
        return languageService.getByForeignLanguageList();

    }

    @PostMapping("/getByForeignLanguageSave")
    public Result getByForeignLanguageSave(@RequestBody ForeignLanguage foreignLanguage) {
        return languageService.getByForeignLanguageSave(foreignLanguage);
    }

    @DeleteMapping("/getByForeignLanguageDelete{languageId}")
    public Result getByForeignLanguageDelete(@PathVariable int languageId) {
        return languageService.getByForeignLanguageDelete(languageId);
    }


}
