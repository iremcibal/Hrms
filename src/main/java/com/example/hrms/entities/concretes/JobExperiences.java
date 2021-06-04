package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
public class JobExperiences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experiences_id")
    private int experiences_id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name="start_at",nullable = false)
    private Date start_at;

    @Column(name = "finish_at",nullable = true)
    private Date finish_at;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;




}
