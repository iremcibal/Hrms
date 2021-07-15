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
    @Column(name = "university_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int universityId;

    @Column(name = "university_name",nullable = false)
    private String university_name;

    @Column(name ="division_name",nullable = false)
    private String division_name;

    @Column(name = "education",nullable = false)
    private String education;

    @Column(name="start_at",nullable = false)
    private Date startAt;

    @Column(name = "finish_at",nullable = true)
    private Date finishAt;

    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;




}
