package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity = Posting.class)
    private Posting posting;

    @ManyToOne(targetEntity = Account.class)
    private Account account;

    public PostTag() {
    }

    public PostTag(Long id, Posting posting, Account account) {
        this.id = id;
        this.posting = posting;
        this.account = account;
    }

    public PostTag(Posting posting, Account account) {
        this.posting = posting;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
