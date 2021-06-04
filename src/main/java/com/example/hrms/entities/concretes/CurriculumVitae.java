package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculumVitae")
    private List<University> university;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculumVitae")
    private List<JobExperiences> jobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculumVitae")
    private List<ForeignLanguage> foreignLanguage;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculumVitae")
    private List<Technology> technology;

    @Column(name = "github")
    private String gitHub;

    @Column(name = "linkedın")
    private String linkedın;

    @Column(name = "front_note")
    private String front_note;


}
