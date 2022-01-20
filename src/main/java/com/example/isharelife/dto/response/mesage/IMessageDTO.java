package com.example.isharelife.dto.response.mesage;

import java.time.LocalDateTime;

public interface IMessageDTO {
    Long getId();
    Long getIdGuest();
    String getContent();
    String getDateSend();
    String getNameReceiver();
    String getNameSender();
    Long getidReceiver();
}
