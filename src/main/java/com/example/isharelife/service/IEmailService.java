package com.example.isharelife.service;

import com.example.isharelife.model.email.MailObject;

public interface IEmailService {
    void sendSimpleMessage(MailObject mail);
}
