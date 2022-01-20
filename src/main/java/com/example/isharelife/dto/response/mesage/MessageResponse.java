package com.example.isharelife.dto.response.mesage;

public class MessageResponse {
    private String content;
    private String dateSend;
    private Long idSender;
    private Long idReceiver;

    public MessageResponse(String content, String dateSend, Long idSender, Long idReceiver) {
        this.content = content;
        this.dateSend = dateSend;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
    }

    public MessageResponse() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(Long idReceiver) {
        this.idReceiver = idReceiver;
    }
}
