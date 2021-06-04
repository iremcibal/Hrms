package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//Lisans-Doktora vs
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private int educationId;

    @Column(name = "education_name")
    private String educationName;

    @JsonIgnore
    @OneToOne(mappedBy = "education")
    private University university;
}
