package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost,Integer> {

    List<JobPost> getByCompanyNameList(String companyName);
}
