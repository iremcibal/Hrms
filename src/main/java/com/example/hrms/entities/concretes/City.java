package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id",nullable = false)
    private int cityId;

    @Column(name = "city_name",nullable = false)
    private String cityName;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<JobPost> jobPosts;




}
