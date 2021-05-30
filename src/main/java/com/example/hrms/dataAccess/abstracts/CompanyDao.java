package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {
    Company getByEmail(String email);
    Company findByCompanyName(String companyName);
}
