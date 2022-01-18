package com.example.isharelife.controller.post;

import com.example.isharelife.model.account.Account;
import com.example.isharelife.model.post.CommentLike;
import com.example.isharelife.model.post.PostLike;
import com.example.isharelife.model.post.Posting;
import com.example.isharelife.model.post.PostingComment;
import com.example.isharelife.service.IAccountService;
import com.example.isharelife.service.post.ICommentLikeService;
import com.example.isharelife.service.post.IPostLikeService;
import com.example.isharelife.service.post.IPostingCommentService;
import com.example.isharelife.service.post.IPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/commentLike")
public class CommentLikeRestController {

    @Autowired
    ICommentLikeService commentLikeService;

    @Autowired
    IPostingCommentService postingCommentService;

    @Autowired
    IAccountService accountService;

    @GetMapping
    public ResponseEntity<Iterable<CommentLike>> findAllCommentLike() {
        return new ResponseEntity<>(commentLikeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentLike> findCommentLikeById(@PathVariable Long id) {
        return new ResponseEntity<>(commentLikeService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentLike> save(@RequestBody CommentLike commentLike) {
        commentLikeService.save(commentLike);
        return new ResponseEntity<>(commentLike, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentLike> updateCommentLike(@PathVariable Long id, @RequestBody CommentLike commentLike) {
        Optional<CommentLike> commentLikeOptional=commentLikeService.findById(id);
        if (!commentLikeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentLike.setId(commentLikeOptional.get().getId());
        commentLikeService.save(commentLike);
        return new ResponseEntity<>(commentLike, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentLike> deleteCommentLike(@PathVariable Long id) {
        Optional<CommentLike> commentLikeOptional = commentLikeService.findById(id);
        if (!commentLikeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentLikeService.remove(id);
        return new ResponseEntity<>(commentLikeOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Integer> getLikesByPostingCommentId(@PathVariable Long id) {
        Integer like = 0;
        like = commentLikeService.countCommentLikeByPostingCommentId(id);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @GetMapping("/liked/{cId}/{accId}")
    public ResponseEntity<Boolean> isLiked(@PathVariable Long cId, @PathVariable Long accId) {
        Account account = accountService.findAccountById(accId).get();
        return new ResponseEntity<>(commentLikeService.existsByPostingCommentIdAndOwner(cId, account), HttpStatus.OK);
    }

    @PostMapping("/doLike/{cId}/{accId}")
    public ResponseEntity<?> doLike(@PathVariable Long cId, @PathVariable Long accId) {
        PostingComment postingComment = postingCommentService.findById(cId).get();
        Account account = accountService.findAccountById(accId).get();
        CommentLike commentLike = new CommentLike(account, postingComment);
        commentLikeService.save(commentLike);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping("/unLike/{cId}/{accId}")
    public ResponseEntity<?> unLike(@PathVariable Long cId, @PathVariable Long accId) {
        CommentLike commentLike = commentLikeService.findCommentLikeByPostingCommentIdAndOwnerId(cId, accId).get();
        commentLikeService.remove(commentLike.getId());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
