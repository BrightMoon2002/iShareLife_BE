package com.example.isharelife.model.relationship;

import com.example.isharelife.model.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RelationshipAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = RelationshipType.class)
    private RelationshipType relationshipType;
    @ManyToOne(targetEntity = Account.class)
    private Account account1;
    @ManyToOne(targetEntity = Account.class)
    private Account account2;

}
