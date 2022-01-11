package com.example.isharelife.model.chat_room;

import javax.persistence.*;

@Entity
@Table
public class StatusChatRoomMessageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    public StatusChatRoomMessageType() {
    }

    public StatusChatRoomMessageType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public StatusChatRoomMessageType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
