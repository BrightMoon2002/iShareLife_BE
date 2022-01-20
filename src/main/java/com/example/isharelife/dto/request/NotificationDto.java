package com.example.isharelife.dto.request;

import lombok.Data;

@Data
public class NotificationDto {
    private Long id;
    private String senderName;
    private String message;
    private String receiverName;
    private Integer status;
}
