package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foreign_language")
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int language_id;

    @Column(name = "language")
    private String language;

    @OneToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;

}
