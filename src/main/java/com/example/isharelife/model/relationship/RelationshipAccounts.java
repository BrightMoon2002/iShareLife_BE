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

    public RelationshipAccounts() {
    }

    public RelationshipAccounts(Long id, RelationshipType relationshipType, Account account1, Account account2) {
        this.id = id;
        this.relationshipType = relationshipType;
        this.account1 = account1;
        this.account2 = account2;
    }

    public RelationshipAccounts(RelationshipType relationshipType, Account account1, Account account2) {
        this.relationshipType = relationshipType;
        this.account1 = account1;
        this.account2 = account2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    public Account getAccount1() {
        return account1;
    }

    public void setAccount1(Account account1) {
        this.account1 = account1;
    }

    public Account getAccount2() {
        return account2;
    }

    public void setAccount2(Account account2) {
        this.account2 = account2;
    }
}
