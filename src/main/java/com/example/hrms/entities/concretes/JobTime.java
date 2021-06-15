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
@Table(name = "jobtime")
public class JobTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobtime_id",nullable = false)
    private int jobtime_id;

    @Column(name = "time_name",nullable = false)
    private String timeName;

    @JsonIgnore
    @OneToMany(mappedBy = "jobTime")
    private List<JobPost> jobPosts;



}
