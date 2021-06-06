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

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;

}
