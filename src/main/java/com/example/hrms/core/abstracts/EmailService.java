package com.example.hrms.core.abstracts;


//e-posta doğrulaması simülasyonu
public interface EmailService {
    //boolean isValidEmail(String email); ->Geçerli bir email mi?

    void sendLinkForMail(String email);
    void activeLinkForMail(String email);

}
