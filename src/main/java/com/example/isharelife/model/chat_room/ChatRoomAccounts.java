package com.example.isharelife.model.chat_room;

import com.example.isharelife.model.account.Account;

import javax.persistence.*;

@Entity
@Table
public class ChatRoomAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ChatRoom.class)
    private ChatRoom chatRoom;

    @ManyToOne(targetEntity = Account.class)
    private Account account;

    public ChatRoomAccounts() {
    }

    public ChatRoomAccounts(Long id, ChatRoom chatRoom, Account account) {
        this.id = id;
        this.chatRoom = chatRoom;
        this.account = account;
    }

    public ChatRoomAccounts(ChatRoom chatRoom, Account account) {
        this.chatRoom = chatRoom;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
