package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.abstracts.EmailService;
import com.example.hrms.core.abstracts.UserCheckService;
import com.example.hrms.core.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.dtos.CurriculumVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesManager implements CandidateService {
    private CandidateDao candidateDao;
    private ImageService imageService;
    private UniversityService universityService;
    private JobExperienceService jobExperienceService;
    private TechnologyService technologyService;
    private LanguageService languageService;
    private CvDetailService cvDetailService;
    private UserCheckService userCheckService;
    private EmailService emailService;

    @Autowired
    public CandidatesManager(CandidateDao candidateDao, ImageService imageService, UniversityService universityService, JobExperienceService jobExperienceService, TechnologyService technologyService, LanguageService languageService, CvDetailService cvDetailService, UserCheckService userCheckService, EmailService emailService) {
        this.candidateDao = candidateDao;
        this.imageService = imageService;
        this.universityService = universityService;
        this.jobExperienceService = jobExperienceService;
        this.technologyService = technologyService;
        this.languageService = languageService;
        this.cvDetailService = cvDetailService;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Candidates>> getByCandidateList() {
        return new SuccessDataResult<List<Candidates>>(candidateDao.findAll(),"Data listelendi");
    }

    @Override
    public Result addByCandidateSave(Candidates candidates) {
        if( candidates.getName().isEmpty() || candidates.getLastName().isEmpty() || candidates.getNationaltyNo().isEmpty()
                || String.valueOf(candidates.getBirthDate()).isEmpty() || candidates.getEmail().isEmpty()
                || candidates.getPassword().isEmpty()){
            return new ErrorResult("L??tfen bilgileri eksiksiz giriniz.");
        }
        else if(!this.userCheckService.CheckIfRealPerson(candidates)){
            return new ErrorResult("Ger??ek kimli??inizle giri?? yap??n??z.");
        }
        else if(this.candidateDao.getByEmail(candidates.getEmail())!=null || this.candidateDao.getByNationaltyNo(candidates.getNationaltyNo())!=null){
            return new ErrorResult("Daha ??nce kullan??lmam???? bilgiler giriniz.");
        }

        this.emailService.sendLinkForMail(candidates.getEmail());
        System.out.println("----------------------------");
        this.emailService.activeLinkForMail(candidates.getEmail());
        candidateDao.save(candidates);
        return new SuccessResult("Yeni ??ye kaydedildi.");

    }

    @Override
    public DataResult<CurriculumVitaeDto> getCurriculumVitaeById(int id) {
        CurriculumVitaeDto curriculumVitaeDto = new CurriculumVitaeDto();

        curriculumVitaeDto.setCandidates(this.candidateDao.findById(id));
        curriculumVitaeDto.setImage(this.imageService.getByCandidatesId(id).getData());
        curriculumVitaeDto.setUniversities(this.universityService.getByCandidatesId(id).getData());
        curriculumVitaeDto.setJobExperiences(this.jobExperienceService.getByCandidatesId(id).getData());
        curriculumVitaeDto.setTechnologies(this.technologyService.getByCandidatesId(id).getData());
        curriculumVitaeDto.setForeignLanguages(this.languageService.getByCandidateId(id).getData());
        curriculumVitaeDto.setCvDetails(this.cvDetailService.getByCandidatesId(id).getData());

        return new SuccessDataResult<CurriculumVitaeDto>(curriculumVitaeDto,"Data listelendi.");

    }
    //Status truelar?? listeleme
    @Override
    public DataResult<CurriculumVitaeDto> getCurriculumVitaeByIdAndStatusTrue(int id) {
        CurriculumVitaeDto curriculumVitaeDto = new CurriculumVitaeDto();

        curriculumVitaeDto.setCandidates(this.candidateDao.getByCandidatesIdAndStatusTrue(id));
        curriculumVitaeDto.setImage(this.imageService.getByCandidatesIdAndStatusTrue(id).getData());
        curriculumVitaeDto.setUniversities(this.universityService.getByCandidatesIdAndStatusTrue(id).getData());
        curriculumVitaeDto.setJobExperiences(this.jobExperienceService.getByCandidatesIdAndStatusTrue(id).getData());
        curriculumVitaeDto.setTechnologies(this.technologyService.getByCandidatesIdAndStatusTrue(id).getData());
        curriculumVitaeDto.setForeignLanguages(this.languageService.getByCandidatesIdAndStatusTrue(id).getData());
        curriculumVitaeDto.setCvDetails(this.cvDetailService.getByCandidatesIdAndStatusTrue(id).getData());

        return new SuccessDataResult<CurriculumVitaeDto>(curriculumVitaeDto,"Data listelendi.");
    }

    //Status false listeleme
    @Override
    public DataResult<CurriculumVitaeDto> getCurriculumVitaeByIdAndStatusFalse(int id) {
        CurriculumVitaeDto curriculumVitaeDto = new CurriculumVitaeDto();

        curriculumVitaeDto.setCandidates(this.candidateDao.getByCandidatesIdAndStatusFalse(id));
        curriculumVitaeDto.setImage(this.imageService.getByCandidatesIdAndStatusFalse(id).getData());
        curriculumVitaeDto.setUniversities(this.universityService.getByCandidatesIdAndStatusFalse(id).getData());
        curriculumVitaeDto.setJobExperiences(this.jobExperienceService.getByCandidatesIdAndStatusFalse(id).getData());
        curriculumVitaeDto.setTechnologies(this.technologyService.getByCandidatesIdAndStatusFalse(id).getData());
        curriculumVitaeDto.setForeignLanguages(this.languageService.getByCandidatesIdAndStatusFalse(id).getData());
        curriculumVitaeDto.setCvDetails(this.cvDetailService.getByCandidatesIdAndStatusFalse(id).getData());

        return new SuccessDataResult<CurriculumVitaeDto>(curriculumVitaeDto,"Data listelendi.");
    }


    @Override
    public Result getByCandidateDelete(String nationaltyNo) {
        Candidates candidates = candidateDao.findByNationaltyNo(nationaltyNo);
        candidateDao.delete(candidates);
        return new SuccessResult("??ye silindi.");
    }


}
