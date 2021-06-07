package com.example.hrms.entities.concretes.dtos;


import com.example.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {

    private Candidates candidates;
    private List<Image> image;
    private List<University> universities;
    private List<Technology> technologies;
    private List<JobExperiences> jobExperiences;
    private List<ForeignLanguage> foreignLanguages;
    private List<CvDetails> cvDetails;






}
