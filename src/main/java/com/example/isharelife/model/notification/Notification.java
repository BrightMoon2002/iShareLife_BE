package com.example.isharelife.model.notification;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.Posting;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    private String action;
    @ManyToOne(targetEntity = Account.class)
    private Account account;
    @OneToOne
    @JoinColumn(name = "posting_id")
    private Posting posting;
    private Boolean status;
}
