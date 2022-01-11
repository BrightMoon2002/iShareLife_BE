package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.PostLike;
import com.example.isharelife.model.post.PostingStatusType;
import com.example.isharelife.service.post.IPostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/postLike")
public class PostLikeRestController {

    @Autowired
    IPostLikeService postLikeService;

    @GetMapping
    public ResponseEntity<Iterable<PostLike>> findAllPostLikeType() {
        return new ResponseEntity<>(postLikeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostLike> findPostLikeById(@PathVariable Long id) {
        return new ResponseEntity<>(postLikeService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostLike> save(@RequestBody PostLike postLike) {
        postLikeService.save(postLike);
        return new ResponseEntity<>(postLike, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostLike> updatePostLike(@PathVariable Long id, @RequestBody PostLike postLike) {
        Optional<PostLike> postLikeOptional=postLikeService.findById(id);
        if (!postLikeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postLike.setId(postLikeOptional.get().getId());
        postLikeService.save(postLike);
        return new ResponseEntity<>(postLike, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostLike> deletePostLike(@PathVariable Long id) {
        Optional<PostLike> postLikeOptional = postLikeService.findById(id);
        if (!postLikeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postLikeService.remove(id);
        return new ResponseEntity<>(postLikeOptional.get(), HttpStatus.NO_CONTENT);
    }

}