package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.PostingComment;
import com.example.isharelife.service.post.IPostingCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/postingComment")
public class PostingCommentRestController {

    @Autowired
    IPostingCommentService postingCommentService;

    @GetMapping
    public ResponseEntity<Iterable<PostingComment>> findAllPostingComment() {
        return new ResponseEntity<>(postingCommentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostingComment> findPostingCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(postingCommentService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostingComment> save(@RequestBody PostingComment postingComment) {
        postingCommentService.save(postingComment);
        return new ResponseEntity<>(postingComment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostingComment> updatePostingComment(@PathVariable Long id, @RequestBody PostingComment postingComment) {
        Optional<PostingComment> postingCommentOptional=postingCommentService.findById(id);
        if (!postingCommentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingComment.setId(postingCommentOptional.get().getId());
        postingCommentService.save(postingComment);
        return new ResponseEntity<>(postingComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostingComment> deletePostingComment(@PathVariable Long id) {
        Optional<PostingComment> postingCommentOptional = postingCommentService.findById(id);
        if (!postingCommentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingCommentService.remove(id);
        return new ResponseEntity<>(postingCommentOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/post/all/{id}")
    public ResponseEntity<Iterable<PostingComment>> getCommentByPostingId(@PathVariable Long id) {
        Iterable<PostingComment> postingComments = postingCommentService.findPostingCommentsByPostingId(id);
        return new ResponseEntity<>(postingComments, HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Iterable<PostingComment>> getCommentByPostingIdLimit(@PathVariable Long id) {
        Iterable<PostingComment> postingComments = postingCommentService.findPostingCommentsByPostingIdLimit(id);
        return new ResponseEntity<>(postingComments, HttpStatus.OK);
    }
}
