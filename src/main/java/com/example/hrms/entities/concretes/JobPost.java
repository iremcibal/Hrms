package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

    @Column(name="status",columnDefinition="boolean default false",nullable = false)
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Positions positions;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company ;

    @ManyToOne()
    @JoinColumn(name="jobtype_id")
    private JobType jobType;

    @ManyToOne()
    @JoinColumn(name="jobtime_id")
    private JobTime jobTime;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPost")
    private List<Favorite> favorites;





}
