package com.example.hrms.business.abstracts;


import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface LanguageService {
    DataResult<List<ForeignLanguage>> getByForeignLanguageList();
    Result getByForeignLanguageSave(ForeignLanguage foreignLanguage);
    Result getByForeignLanguageDelete(int languageId);

    DataResult<List<ForeignLanguage>> getByCandidateId(int id);

    DataResult<List<ForeignLanguage>> getByCandidatesIdAndStatusTrue(int id);
    DataResult<List<ForeignLanguage>> getByCandidatesIdAndStatusFalse(int id);
}
