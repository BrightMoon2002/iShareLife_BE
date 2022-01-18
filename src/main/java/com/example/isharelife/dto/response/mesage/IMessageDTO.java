package com.example.isharelife.dto.response.mesage;

import java.time.LocalDateTime;

public interface IMessageDTO {
    Long getId();
    String getContent();
    LocalDateTime getDateSend();
    String getNameReceiver();
    String getNameSender();
}
