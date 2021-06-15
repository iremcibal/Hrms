package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    private String education;

    @Column(name="start_at",nullable = false)
    private LocalDate startAt;

    @Column(name = "finish_at",nullable = true)
    private LocalDate finishAt;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;




}
