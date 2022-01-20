package com.example.isharelife.service.relationship;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.relationship.RelationshipAccounts;
import com.example.isharelife.model.relationship.RelationshipType;
import com.example.isharelife.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IRelationshipAccountService extends IGeneralService<RelationshipAccounts> {
    Iterable<RelationshipAccounts> findAllByAccount2AndRelationshipType(Account account2, Long id);

    Iterable<RelationshipAccounts> findAllByAccount1AndRelationshipType(Account account1, Long id);

    Optional<RelationshipAccounts> findByAccount1IdAndAccount2Id(Long id1, Long id2);
//    Optional<RelationshipAccounts> findRelationship(int id1,int id2);

    //    void changeRelationship(Long Rid,Long id);
    void changeIsShow(Long id);


}
