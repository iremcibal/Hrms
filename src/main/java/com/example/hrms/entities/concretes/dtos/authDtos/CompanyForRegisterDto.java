package com.example.hrms.entities.concretes.dtos.authDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyForRegisterDto {
    private String companyName;
    private String webSite;
    private String telePhone;
    private String email;
    private String password;


}
