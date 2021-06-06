package com.example.hrms.api;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.dtos.CurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/candidates")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getByCandidateList")
    public DataResult<List<Candidates>> getByCandidateList(){
        return candidateService.getByCandidateList();
    }

    @PutMapping("/cvList")
    public DataResult<CurriculumVitaeDto> getCurriculumVitaeById(@RequestBody int id) {
        return candidateService.getCurriculumVitaeById(id);
    }

    @PostMapping("/addCandidate")
    public Result getByCandidateSave(@RequestBody Candidates candidates){
        return candidateService.getByCandidateSave(candidates);
    }


    @DeleteMapping("/delete{nationaltyNo}")
    public Result getByCandidateDelete(@PathVariable String nationaltyNo){
        return candidateService.getByCandidateDelete(nationaltyNo);
    }




}
