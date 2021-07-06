package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id",nullable = false)
    private int favoriteId;

    @ManyToOne()
    @JoinColumn(name="jobpost_id")
    private JobPost jobPost;

    @ManyToOne()
    @JoinColumn(name="candidates_id")
    private Candidates candidates;



}
