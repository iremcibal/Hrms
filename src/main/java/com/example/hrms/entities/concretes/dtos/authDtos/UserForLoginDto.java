package com.example.hrms.entities.concretes.dtos.authDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForLoginDto {
    private String email;
    private String password;


}
