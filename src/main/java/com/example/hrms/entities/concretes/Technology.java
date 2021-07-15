package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private int technologyId;

    @Column(name = "technology_name")
    private String technologyName;

    private String level;

    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;

}
