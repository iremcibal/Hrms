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
@Table(name = "job_experiences")
public class JobExperiences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experiences_id")
    private int experiencesId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position_name")
    private String positionName;

    @Column(name="start_at",nullable = false)
    private Date startAt;

    @Column(name = "finish_at",nullable = true)
    private Date finishAt;

    @Column(name="status",columnDefinition="boolean default false",nullable = false)
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;




}
