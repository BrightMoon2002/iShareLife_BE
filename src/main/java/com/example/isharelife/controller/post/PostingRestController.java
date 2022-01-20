package com.example.isharelife.controller.post;

import com.example.isharelife.dto.response.ResponseMessage;
import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.Posting;
import com.example.isharelife.model.relationship.RelationshipAccounts;
import com.example.isharelife.security.userprincipal.AccountDetailService;
import com.example.isharelife.service.post.IPostingService;
import com.example.isharelife.service.relationship.IRelationshipAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posting")
public class PostingRestController {

    @Autowired
    IRelationshipAccountService relationshipAccountService;

    @Autowired
    IPostingService postingService;

    @Autowired
    AccountDetailService accountDetailService;

    @GetMapping
    public ResponseEntity<Iterable<Posting>> findAllPosting() {
        return new ResponseEntity<>(postingService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posting> findPostingById(@PathVariable Long id) {
        return new ResponseEntity<>(postingService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Posting> save(@RequestBody Posting posting) {
        postingService.save(posting);
        return new ResponseEntity<>(posting, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posting> updatePosting(@PathVariable Long id, @RequestBody Posting posting) {
        Optional<Posting> postingOptional = postingService.findById(id);
        if (!postingOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        posting.setId(postingOptional.get().getId());
        postingService.save(posting);
        return new ResponseEntity<>(posting, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Posting> deletePosting(@PathVariable Long id) {
        Optional<Posting> postingOptional = postingService.findById(id);
        if (!postingOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingService.remove(id);
        return new ResponseEntity<>(postingOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPost(@RequestParam("content") String content) {
        Account account = accountDetailService.getCurrentUser();
        if (account.getUsername().equals("anonymous")) {
            return new ResponseEntity<>(new ResponseMessage("Please Login"), HttpStatus.OK);
        }
        Iterable<Posting> postings = postingService.findPostingsByContentContainsAndAndPostingStatusType(content, 3L);
        List<Posting> postings1=(List<Posting>)postings;
        Iterable<RelationshipAccounts> relationshipAccounts = relationshipAccountService.findAllByAccount1AndRelationshipType(account,2L);
        List<Posting> list2 = new ArrayList<Posting>();
        List<RelationshipAccounts> relationshipAccounts1=(List<RelationshipAccounts>) relationshipAccounts;
        for (int i = 0; i < postings1.size(); i++) {
            if(account.getId()==postings1.get(i).getOwner().getId()
            ){
                list2.add(postings1.get(i));
            }else {
                for (int j = 0; j < relationshipAccounts1.size(); j++) {
                    if(postings1.get(i).getOwner().getId()==relationshipAccounts1.get(j).getAccount2().getId()){
                        list2.add(postings1.get(i));
                        break;
                    }
                }
            }
        }
        Iterable<Posting> postings2 = postingService.findPostingsByContentContainsAndAndPostingStatusType(content, 1L);
        for (Posting str : postings2) {
            list2.add(str);
        }

        return new ResponseEntity<>(list2, HttpStatus.OK);
    }

}
