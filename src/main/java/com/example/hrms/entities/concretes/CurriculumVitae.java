package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculumVitae")
public class CurriculumVitae {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cv_id;

    @OneToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<University> university;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<JobExperiences> jobExperiences;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<ForeignLanguage> foreignLanguage;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<Technology> technology;

    @Column(name = "github")
    private String gitHub;

    @Column(name = "linkedın")
    private String linkedın;

    @Column(name = "front_note")
    private String front_note;


}
