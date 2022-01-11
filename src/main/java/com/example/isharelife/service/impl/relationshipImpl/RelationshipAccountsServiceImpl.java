package com.example.isharelife.service.impl.relationshipImpl;

import com.example.isharelife.model.relationship.RelationshipAccounts;
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
    public void save(RelationshipAccounts relationshipAccounts) {
        relationshipAccountsRepository.save(relationshipAccounts);
    }

    @Override
    public void remove(Long id) {
        relationshipAccountsRepository.deleteById(id);
    }
}
