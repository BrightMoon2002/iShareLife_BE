package com.example.isharelife.dto.response.mesage;

public class MessageResponseAfterCreate {
    private Long id;
    private String content;
    private Long idGuest;
    private String dateSend;
    private String nameReceiver;
    private String nameSender;

    public MessageResponseAfterCreate() {
    }

    public MessageResponseAfterCreate(Long id, String content, Long idGuest, String dateSend, String nameReceiver, String nameSender) {
        this.id = id;
        this.content = content;
        this.idGuest = idGuest;
        this.dateSend = dateSend;
        this.nameReceiver = nameReceiver;
        this.nameSender = nameSender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Long idGuest) {
        this.idGuest = idGuest;
    }

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }
}
