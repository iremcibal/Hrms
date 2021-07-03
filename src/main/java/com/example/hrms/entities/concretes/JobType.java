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
@Table(name = "jobtype")
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobtype_id",nullable = false)
    private int jobtypeId;

    @Column(name = "type_name",nullable = false)
    private String typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "jobType")
    private List<JobPost> jobPosts;
}
