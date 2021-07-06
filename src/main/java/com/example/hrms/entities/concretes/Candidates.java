package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//iş arayanlar
@Entity
@Data
@Table(name = "candidate")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidates extends Users{
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "nationaltyno")
    private String nationaltyNo;

    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @OneToOne(mappedBy = "candidates")
    private Image image;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    private List<University> university;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    @PrimaryKeyJoinColumn
    private List<JobExperiences> jobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    private List<ForeignLanguage> foreignLanguage;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    private List<Technology> technology;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    private List<CvDetails> cvDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    private List<Favorite> favorites;


}

