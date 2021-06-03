package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university")
public class University {
    @Id
    @Column(name = "university")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_id;

    @Column(name = "university_name",nullable = false)
    private String university_name;

    @Column(name ="division_name",nullable = false)
    private String division_name;

    @OneToOne()
    @JoinColumn(name = "education_id")
    private Education education;

    @Column(name="start_at",nullable = false)
    private Date start_at;

    @Column(name = "finish_at",nullable = true)
    private Date finish_at;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;




}
