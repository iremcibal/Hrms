package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeDao extends JpaRepository<JobType,Integer> {
}
