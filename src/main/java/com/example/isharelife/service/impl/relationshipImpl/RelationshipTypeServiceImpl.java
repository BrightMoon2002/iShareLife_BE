package com.example.isharelife.service.impl.relationshipImpl;

import com.example.isharelife.model.relationship.RelationshipType;
import com.example.isharelife.repository.relationship.IRelationshipTypeRepository;
import com.example.isharelife.service.relationship.IRelationshipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RelationshipTypeServiceImpl implements IRelationshipTypeService {
    @Autowired
    IRelationshipTypeRepository relationshipTypeRepository;

    @Override
    public Iterable<RelationshipType> findAll() {
        return relationshipTypeRepository.findAll();
    }

    @Override
    public Optional<RelationshipType> findById(Long id) {
        return relationshipTypeRepository.findById(id);
    }

    @Override
    public void save(RelationshipType relationshipType) {
        relationshipTypeRepository.save(relationshipType);
    }

    @Override
    public void remove(Long id) {
        relationshipTypeRepository.deleteById(id);
    }
}
