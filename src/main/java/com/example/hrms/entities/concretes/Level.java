package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Başlangıç-Orta-İleri
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private int levelId;

    @Column(name = "level")
    private String level;

    @JsonIgnore
    @OneToOne(mappedBy = "level")
    private Technology technology;

    @JsonIgnore
    @OneToOne(mappedBy = "level")
    private ForeignLanguage foreignLanguage;

}
