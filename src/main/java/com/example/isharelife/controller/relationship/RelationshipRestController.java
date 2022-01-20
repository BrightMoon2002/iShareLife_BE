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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
// Danh sách yêu cầu kết bạn nhận được
    @GetMapping("/showPending")
    public ResponseEntity<?> allPending() {
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Iterable<RelationshipAccounts> list = relationshipAccountService.findAllByAccount2AndRelationshipType(account, Long.valueOf(1));
        List<Account> listPending=new ArrayList<Account>();
        for (RelationshipAccounts re: list
        ) {
            listPending.add(re.getAccount1());
        }
        return new ResponseEntity<>(listPending, HttpStatus.OK);
    }
// Danh sách lời mời kết bạn mình gửi đi
    @GetMapping("/showListAdd")
    public ResponseEntity<?> allRequest() {
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Iterable<RelationshipAccounts> list = relationshipAccountService.findAllByAccount1AndRelationshipType(account, Long.valueOf(1));
        List<Account> listAdd=new ArrayList<Account>();
        for (RelationshipAccounts re: list
        ) {
            listAdd.add(re.getAccount2());
        }
        return new ResponseEntity<>(listAdd, HttpStatus.OK);
    }
// Đồng ý kết bạn
    @PutMapping("/accept/{id1}")
    public ResponseEntity<?> accept(@PathVariable Long id1) {
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Long id2 = account.getId();
        RelationshipType relationshipType = relationshipTypeService.findById(Long.valueOf(2)).get();
        RelationshipAccounts relationshipAccounts = relationshipAccountService.findByAccount1IdAndAccount2Id(id1, id2).get();
        Account accountFriend = accountService.findAccountById(id1).get();
        relationshipAccounts.setRelationshipType(relationshipType);
        RelationshipAccounts relationshipAccounts2 = new RelationshipAccounts(relationshipType, account, accountFriend);
        relationshipAccountService.save(relationshipAccounts2);
        return new ResponseEntity<>(new ResponseMessage("add friend complete"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody RelationshipAccounts relationshipAccounts) {
        relationshipAccountService.save(relationshipAccounts);
        return new ResponseEntity<>(relationshipAccounts, HttpStatus.OK);
    }
//Gửi yêu cầu kết bạn
    @PostMapping("/add/{id}")
    public ResponseEntity<?> addFriend(@PathVariable Long id) {
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Account friend = accountService.findAccountById(id).get();
        RelationshipType relationshipType = relationshipTypeService.findById(Long.valueOf(1)).get();
        RelationshipAccounts relationshipAccounts = new RelationshipAccounts(relationshipType, account, friend);
        relationshipAccountService.save(relationshipAccounts);
        return new ResponseEntity<>(relationshipAccounts, HttpStatus.OK);
    }
// Từ chối yêu cầu kết bạn
    @DeleteMapping("/refused/{id}")
    public ResponseEntity<?>refused(@PathVariable Long id){
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        RelationshipAccounts relationshipAccounts = relationshipAccountService.findByAccount1IdAndAccount2Id(id, account.getId()).get();
        relationshipAccountService.remove(relationshipAccounts.getId());
        return new ResponseEntity<>(new ResponseMessage("refused complete"),HttpStatus.OK);
    }
//    xóa kết bạn
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        RelationshipAccounts relationshipAccount1 = relationshipAccountService.findByAccount1IdAndAccount2Id(id, account.getId()).get();
        RelationshipAccounts relationshipAccount2 = relationshipAccountService.findByAccount1IdAndAccount2Id(account.getId(), id).get();
        relationshipAccountService.remove(relationshipAccount1.getId());
        relationshipAccountService.remove(relationshipAccount2.getId());
        return new ResponseEntity<>(new ResponseMessage("delete Friend complete"),HttpStatus.OK);
    }
//    list bạn bè
    @GetMapping("/listFriend/{id}")
    public ResponseEntity<?>ListFriend(@PathVariable Long id){
        Account account=accountService.findAccountById(id).get();
        Iterable<RelationshipAccounts> list=relationshipAccountService.findAllByAccount1AndRelationshipType(account,Long.valueOf(2));
        List<Account> listFriend=new ArrayList<Account>();
        for (RelationshipAccounts re: list
             ) {
            listFriend.add(re.getAccount2());
        }
        return new ResponseEntity<>(listFriend,HttpStatus.OK);
    }
// Danh sách bạn bè chung
    @GetMapping("/mutualFriend/{id}")
    public ResponseEntity<?>ListMutualFriend(@PathVariable Long id){
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Account friendAccount=accountService.findAccountById(id).get();
        Iterable<RelationshipAccounts> listFriend1=relationshipAccountService.findAllByAccount1AndRelationshipType(account,Long.valueOf(2));

        List<RelationshipAccounts> list1 = new ArrayList<RelationshipAccounts>();
        for (RelationshipAccounts str : listFriend1) {
            list1.add(str);
        }
        Iterable<RelationshipAccounts> listFriend2=relationshipAccountService.findAllByAccount1AndRelationshipType(friendAccount,Long.valueOf(2));
        List<RelationshipAccounts> list2 = new ArrayList<RelationshipAccounts>();
        for (RelationshipAccounts str : listFriend2) {
            list2.add(str);
        }
        List<Account> mutualFriend = new ArrayList<Account>();

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(list1.get(i).getAccount2().getId()==list2.get(j).getAccount2().getId()){
                    mutualFriend.add(list1.get(i).getAccount2());
                    break;
                }
            }
        }

        return new ResponseEntity<>(mutualFriend,HttpStatus.OK);
    }

//    check tình trạng quan hệ
    @GetMapping("/checkRelationship/{id}")
    public ResponseEntity<?> checkRelationship(@PathVariable Long id){
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Optional<RelationshipAccounts> relationshipAccounts= relationshipAccountService.findByAccount1IdAndAccount2Id(account.getId(),id);

        if(relationshipAccounts.isPresent()) {
            if (relationshipAccounts.get().getRelationshipType().getId() == 1) {
                return new ResponseEntity<>(1,HttpStatus.OK);
            }
            if (relationshipAccounts.get().getRelationshipType().getId() == 2) {
                return new ResponseEntity<>(2,HttpStatus.OK);
            }
            if (relationshipAccounts.get().getRelationshipType().getId() == 3) {
                return new ResponseEntity<>(3,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(0,HttpStatus.OK);
    }

    @PutMapping("/isShow")
    public ResponseEntity<?> changeIsShow(){
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        relationshipAccountService.changeIsShow(account.getId());
        return new ResponseEntity<>(new ResponseMessage("change is show complete"),HttpStatus.OK);
    }
}
