package com.example.hrms.dataAccess.abstracts;


import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageDao extends JpaRepository<ForeignLanguage, Integer> {
    ForeignLanguage getByLanguageId(int languageId);

    List<ForeignLanguage> getByCandidatesId(int id);
}
