package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.CommentLike;
import com.example.isharelife.service.post.ICommentLikeService;
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
}
