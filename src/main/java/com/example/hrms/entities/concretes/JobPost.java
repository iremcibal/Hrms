package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobPost")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobpost_id",nullable = false)
    private int jobPostId;

    @Column(name = "min_salary",nullable = true)
    private int minSalary;

    @Column(name = "max_salary",nullable = true)
    private int maxSalary;

    @Column(name = "position_quota",nullable = false)
    private int positionQuota;

    @Column(name = "position_title",nullable = false)
    private String positionTitle;

    @Column(name = "deadline",nullable =false)
    private Date deadLine;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "is_active",nullable = false)
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Positions positions;

    @ManyToOne()
    @JoinColumn(name = "id")
    private Company company;








}
