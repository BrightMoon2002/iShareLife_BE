package com.example.isharelife.controller.relationship;

import com.example.isharelife.model.post.PostingStatusType;
import com.example.isharelife.model.relationship.RelationshipType;
import com.example.isharelife.service.relationship.IRelationshipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/relationshipType")
public class RelationshipTypeRestController {
    @Autowired
    IRelationshipTypeService relationshipTypeService;

    @GetMapping
    public ResponseEntity<Iterable<RelationshipType>> finđAll() {
        return new ResponseEntity<>(relationshipTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationshipType> findById(@PathVariable Long id) {
        return new ResponseEntity<>(relationshipTypeService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RelationshipType> save(@RequestBody RelationshipType relationshipType) {
        relationshipTypeService.save(relationshipType);
        return new ResponseEntity<>(relationshipType, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelationshipType> update(@PathVariable Long id, @RequestBody RelationshipType relationshipType) {
        Optional<RelationshipType> relationshipType1=relationshipTypeService.findById(id);
        if (!relationshipType1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        relationshipType.setId(relationshipType1.get().getId());
        relationshipTypeService.save(relationshipType);
        return new ResponseEntity<>(relationshipType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RelationshipType> delete(@PathVariable Long id) {
        Optional<RelationshipType> relationshipType = relationshipTypeService.findById(id);
        if (!relationshipType.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        relationshipTypeService.remove(id);
        return new ResponseEntity<>(relationshipType.get(), HttpStatus.NO_CONTENT);
    }
}
