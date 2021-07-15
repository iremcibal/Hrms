package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_details")
public class CvDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_details_id")
    private int cvDetailsId;

    @Column(name = "github")
    private String gitHub;

    @Column(name = "linkedın")
    private String linkedIn;

    @Column(name = "front_note")
    private String frontNote;

    @Column(name="status",columnDefinition="boolean default false",nullable = false)
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;

}
