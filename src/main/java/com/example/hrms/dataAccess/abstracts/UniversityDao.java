package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityDao extends JpaRepository<University,Integer> {
    University getByUniversityId(int universityId);
    List<University> getByCandidatesId(int candidates_id);

    //Sistem personali için
    List<University> getByCandidatesIdAndStatusTrue(int id);
    List<University> getByCandidatesIdAndStatusFalse(int id);
}
