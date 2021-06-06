package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyDao extends JpaRepository<Technology,Integer> {
    Technology getByTechnologyId(int technologyId);


    List<Technology> getByCandidatesId(int id);

}
