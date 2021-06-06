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
    private int languageId;

    @Column(name = "language")
    private String language;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "candidates_id")
    private Candidates candidates;

}
