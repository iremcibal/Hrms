package com.example.hrms.core.concretes;

import com.example.hrms.core.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceİmp implements EmailService {
    @Override
    public void sendLinkForMail(String email) {
        System.out.println(email + " adresine aktivasyon linki gönderilmiştir.");
    }

    @Override
    public void activeLinkForMail(String email) {
        System.out.println(email + " için aktivasyon işlemi tamamlanmıştır.");

    }
}
