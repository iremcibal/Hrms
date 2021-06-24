package com.example.hrms.entities.concretes.dtos.authDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto {

    private String name;
    private String lastName;
    private String email;
    private String nationaltyNo;
    private LocalDate birthDate;
    private String password;




}
