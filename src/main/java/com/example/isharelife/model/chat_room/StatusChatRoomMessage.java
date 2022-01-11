package com.example.isharelife.model.chat_room;

import javax.persistence.*;

@Entity
@Table
public class StatusChatRoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = ChatRoomMessage.class)
    private ChatRoomMessage chatRoomMessage;

    @OneToOne(targetEntity = StatusChatRoomMessageType.class)
    private StatusChatRoomMessageType statusChatRoomMessageType;

    public StatusChatRoomMessage() {
    }

    public StatusChatRoomMessage(Long id, ChatRoomMessage chatRoomMessage, StatusChatRoomMessageType statusChatRoomMessageType) {
        this.id = id;
        this.chatRoomMessage = chatRoomMessage;
        this.statusChatRoomMessageType = statusChatRoomMessageType;
    }

    public StatusChatRoomMessage(ChatRoomMessage chatRoomMessage, StatusChatRoomMessageType statusChatRoomMessageType) {
        this.chatRoomMessage = chatRoomMessage;
        this.statusChatRoomMessageType = statusChatRoomMessageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatRoomMessage getChatRoomMessage() {
        return chatRoomMessage;
    }

    public void setChatRoomMessage(ChatRoomMessage chatRoomMessage) {
        this.chatRoomMessage = chatRoomMessage;
    }

    public StatusChatRoomMessageType getStatusChatRoomMessageType() {
        return statusChatRoomMessageType;
    }

    public void setStatusChatRoomMessageType(StatusChatRoomMessageType statusChatRoomMessageType) {
        this.statusChatRoomMessageType = statusChatRoomMessageType;
    }
}
