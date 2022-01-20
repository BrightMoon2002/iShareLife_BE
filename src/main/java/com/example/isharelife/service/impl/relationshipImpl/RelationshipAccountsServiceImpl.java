package com.example.isharelife.service.impl.relationshipImpl;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.relationship.RelationshipAccounts;
import com.example.isharelife.model.relationship.RelationshipType;
import com.example.isharelife.repository.relationship.IRelationshipAccountsRepository;
import com.example.isharelife.service.relationship.IRelationshipAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelationshipAccountsServiceImpl implements IRelationshipAccountService {
    @Autowired
    IRelationshipAccountsRepository relationshipAccountsRepository;

    @Override
    public Iterable<RelationshipAccounts> findAll() {
        return relationshipAccountsRepository.findAll();
    }

    @Override
    public Optional<RelationshipAccounts> findById(Long id) {
        return relationshipAccountsRepository.findById(id);
    }

    @Override
    public RelationshipAccounts save(RelationshipAccounts relationshipAccounts) {
       return relationshipAccountsRepository.save(relationshipAccounts);
    }

    @Override
    public void remove(Long id) {
        relationshipAccountsRepository.deleteById(id);
    }

    @Override
    public Iterable<RelationshipAccounts> findAllByAccount2AndRelationshipType(Account account2, Long id) {
        return relationshipAccountsRepository.findAllByAccount2AndRelationshipTypeId(account2,id);
    }

    @Override
    public Iterable<RelationshipAccounts> findAllByAccount1AndRelationshipType(Account account1, Long id) {
        return relationshipAccountsRepository.findAllByAccount1AndRelationshipTypeId(account1,id);
    }

    @Override
    public Optional<RelationshipAccounts> findByAccount1IdAndAccount2Id(Long id1, Long id2) {
        return relationshipAccountsRepository.findRelationshipAccountsByAccount1_IdAndAccount2_Id(id1,id2);
    }

    @Override
    public void changeIsShow(Long id) {
        relationshipAccountsRepository.changeIsShow(id);
    }


//    @Override
//    public Optional<RelationshipAccounts> findRelationship(Long id1, Long id2) {
//        return relationshipAccountsRepository.findRelationshipAccountsByAccount1_IdAndAccount2_Id(id1,id2);
//    }

//    @Override
//    public void changeRelationship(Long Rid, Long id) {
//        relationshipAccountsRepository.changeRelationship(Rid,id);
//    }

}
