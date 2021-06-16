package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTimeDao extends JpaRepository<JobTime, Integer> {
}
