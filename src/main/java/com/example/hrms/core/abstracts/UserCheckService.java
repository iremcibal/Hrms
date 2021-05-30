package com.example.hrms.core.abstracts;


import com.example.hrms.entities.concretes.Candidates;

public interface UserCheckService {
    boolean CheckIfRealPerson(Candidates candidates) ;
}
