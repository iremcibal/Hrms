package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//iş verenler
@Entity
@Data
@Table(name = "company")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPost"})
@AllArgsConstructor
@NoArgsConstructor
public class Company extends Users {
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone")
    private String telePhone;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<JobPost> jobPost;

}
