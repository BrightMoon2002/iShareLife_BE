package com.example.isharelife.model.post;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Account.class)
    private Account owner;

    private String content;

    private Date dateOfPosting;

    @ManyToOne(targetEntity = PostingStatusType.class)
    private PostingStatusType postingStatusType;


}
