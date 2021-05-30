package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionDao extends JpaRepository<Positions, Integer> {
    Positions getByPositionName(String positionName);
    Positions findByPositionName(String positionName);
}
