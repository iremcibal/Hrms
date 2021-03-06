package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobExperiences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperiences,Integer> {
    JobExperiences getByExperiencesId(int experiencesId);

    List<JobExperiences> getByCandidatesId(int candidates_id);

    //Sistem personali için
    List<JobExperiences> getByCandidatesIdAndStatusTrue(int id);
    List<JobExperiences> getByCandidatesIdAndStatusFalse(int id);
}
