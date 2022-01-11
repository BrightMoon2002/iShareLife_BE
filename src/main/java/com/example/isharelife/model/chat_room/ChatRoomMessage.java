package com.example.isharelife.model.chat_room;

import com.example.isharelife.model.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ChatRoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ChatRoom.class)
    private ChatRoom chatRoom;

    @ManyToOne(targetEntity = Account.class)
    private Account sender;

    private String message;

    private boolean isImage;

    private LocalDateTime sentTime;

    public ChatRoomMessage() {
    }

    public ChatRoomMessage(Long id, ChatRoom chatRoom, Account sender, String message, boolean isImage, LocalDateTime sentTime) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.sender = sender;
        this.message = message;
        this.isImage = isImage;
        this.sentTime = sentTime;
    }

    public ChatRoomMessage(ChatRoom chatRoom, Account sender, String message, boolean isImage, LocalDateTime sentTime) {
        this.chatRoom = chatRoom;
        this.sender = sender;
        this.message = message;
        this.isImage = isImage;
        this.sentTime = sentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }
}
