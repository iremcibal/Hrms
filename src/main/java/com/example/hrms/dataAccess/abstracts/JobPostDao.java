package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost,Integer> {
    List<JobPost> getByIsActiveTrue();

    List<JobPost> getByCompany_CompanyName(String companyName);
    List<JobPost> getByIsActive(Boolean status);

    //Sistem personali için
    List<JobPost> getByStatusTrue();
    List<JobPost> getByStatusFalse();

    JobPost getByJobPostId(int jobPostId);
    List<JobPost> getByCompany_Id(int companyId);

    List<JobPost> findByUpdatedAtAndIsActiveTrue(LocalDate localDate);


}
