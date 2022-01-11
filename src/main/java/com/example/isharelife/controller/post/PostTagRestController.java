package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.PostTag;
import com.example.isharelife.service.post.IPostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/postTag")
public class PostTagRestController {

    @Autowired
    IPostTagService postTagService;

    @GetMapping
    public ResponseEntity<Iterable<PostTag>> findAllPostTag() {
        return new ResponseEntity<>(postTagService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostTag> findPostTagById(@PathVariable Long id) {
        return new ResponseEntity<>(postTagService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostTag> save(@RequestBody PostTag postTag) {
        postTagService.save(postTag);
        return new ResponseEntity<>(postTag, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostTag> updatePostTag(@PathVariable Long id, @RequestBody PostTag postTag) {
        Optional<PostTag> postTagOptional=postTagService.findById(id);
        if (!postTagOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postTag.setId(postTagOptional.get().getId());
        postTagService.save(postTag);
        return new ResponseEntity<>(postTag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostTag> deletePostTag(@PathVariable Long id) {
        Optional<PostTag> postTagOptional = postTagService.findById(id);
        if (!postTagOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postTagService.remove(id);
        return new ResponseEntity<>(postTagOptional.get(), HttpStatus.NO_CONTENT);
    }
}
