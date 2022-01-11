package com.example.isharelife.model.chat_room;

import com.example.isharelife.model.account.Account;

import javax.persistence.*;

@Entity
@Table
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;

    public ChatRoom() {
    }

    public ChatRoom(Long id, Account owner) {
        this.id = id;
        this.owner = owner;
    }

    public ChatRoom(Account owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
