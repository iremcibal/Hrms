package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.dtos.CurriculumVitaeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidateDao extends JpaRepository<Candidates,Integer> {
    Candidates getByEmail(String email);
    Candidates getByNationaltyNo(String nationaltyNo);
    Candidates findByNationaltyNo(String nationaltyNo);
    Candidates findById(int id);
}
