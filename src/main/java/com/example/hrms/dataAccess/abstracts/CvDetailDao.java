package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CvDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvDetailDao extends JpaRepository<CvDetails,Integer> {
    List<CvDetails> getByCandidatesId(int id);

    //Sistem personali için
    List<CvDetails> getByCandidatesIdAndStatusTrue(int id);
    List<CvDetails> getByCandidatesIdAndStatusFalse(int id);
}
