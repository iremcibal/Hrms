package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Education;
import com.example.hrms.entities.concretes.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDao extends JpaRepository<Education,Integer> {
    Education getByEducationId(int educationId);

}
