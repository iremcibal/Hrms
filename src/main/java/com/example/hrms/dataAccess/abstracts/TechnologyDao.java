package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyDao extends JpaRepository<Technology,Integer> {
    Technology getByTechnologyId(int technologyId);

}
