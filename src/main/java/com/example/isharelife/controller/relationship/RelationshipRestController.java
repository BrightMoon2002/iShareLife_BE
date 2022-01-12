package com.example.isharelife.controller.relationship;

import com.example.isharelife.dto.response.ResponseMessage;
import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.relationship.RelationshipAccounts;
import com.example.isharelife.model.relationship.RelationshipType;
import com.example.isharelife.security.userprincipal.AccountDetailService;
import com.example.isharelife.service.IAccountService;
import com.example.isharelife.service.relationship.IRelationshipAccountService;
import com.example.isharelife.service.relationship.IRelationshipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/relationship")
public class RelationshipRestController {
    @Autowired
    AccountDetailService accountDetailService;

    @Autowired
    IRelationshipAccountService relationshipAccountService;

    @Autowired
    IRelationshipTypeService relationshipTypeService;

    @Autowired
    IAccountService accountService;

    @GetMapping("/showPending")
    public ResponseEntity<?> allPending(){
        Account account=accountDetailService.getCurrentUser();
        if(account.getUsername().equals("anonymous")){
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Iterable<RelationshipAccounts> listPending=relationshipAccountService.findAllByAccount2AndRelationshipType(account,Long.valueOf(1));
        return new ResponseEntity<>(listPending,HttpStatus.OK);
    }

    @GetMapping("/showListAdd")
    public ResponseEntity<?> allRequest(){
        Account account= accountDetailService.getCurrentUser();
        if(account.getUsername().equals("anonymous")){
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Iterable<RelationshipAccounts> listAdd=relationshipAccountService.findAllByAccount1AndRelationshipType(account,Long.valueOf(1));
        return new ResponseEntity<>(listAdd,HttpStatus.OK);
    }

    @PutMapping("/accept/{id1}")
    public ResponseEntity<?> accept(@PathVariable Long id1){
        Account account= accountDetailService.getCurrentUser();
        if(account.getUsername().equals("anonymous")){
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Long id2= account.getId();
        RelationshipType relationshipType=relationshipTypeService.findById(Long.valueOf(2)).get();
        RelationshipAccounts relationshipAccounts=relationshipAccountService.findByAccount1IdAndAccount2Id(id1,id2).get();
        relationshipAccounts.setRelationshipType(relationshipType);
        return new ResponseEntity<>(new ResponseMessage("add friend complete"),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody RelationshipAccounts relationshipAccounts){
        relationshipAccountService.save(relationshipAccounts);
        return new ResponseEntity<>(relationshipAccounts,HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addFriend(@PathVariable Long id){
        Account account= accountDetailService.getCurrentUser();
        if(account.getUsername().equals("anonymous")){
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Account friend=accountService.findAccountById(id).get();
        RelationshipType relationshipType=relationshipTypeService.findById(Long.valueOf(1)).get();
        RelationshipAccounts relationshipAccounts=new RelationshipAccounts(relationshipType,account,friend);


    }
}
