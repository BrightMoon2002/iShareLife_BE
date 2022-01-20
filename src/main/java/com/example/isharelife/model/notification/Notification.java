package com.example.isharelife.model.notification;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.Posting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    private String action;
    @OneToOne
    @JoinColumn(name = "sender_id")
    private Account sender;
    @ManyToOne(targetEntity = Account.class)
    private Account account;
    @OneToOne
    @JoinColumn(name = "posting_id")
    private Posting posting;
    private LocalDateTime date;
    private Boolean status;
    private int type;
}
