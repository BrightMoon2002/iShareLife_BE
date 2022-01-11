package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.PostingStatusType;
import com.example.isharelife.service.post.IPostingStatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/postingStatusType")
public class PostingStatusTypeRestController {

    @Autowired
    IPostingStatusTypeService postingStatusTypeService;

    @GetMapping
    public ResponseEntity<Iterable<PostingStatusType>> findAllPostingStatusType() {
        return new ResponseEntity<>(postingStatusTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostingStatusType> findPostingStatusTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(postingStatusTypeService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostingStatusType> save(@RequestBody PostingStatusType postingStatusType) {
        postingStatusTypeService.save(postingStatusType);
        return new ResponseEntity<>(postingStatusType, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostingStatusType> updatePostingStatusType(@PathVariable Long id, @RequestBody PostingStatusType postingStatusType) {
        Optional<PostingStatusType> postingStatusTypeOptional=postingStatusTypeService.findById(id);
        if (!postingStatusTypeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingStatusType.setId(postingStatusTypeOptional.get().getId());
        postingStatusTypeService.save(postingStatusType);
        return new ResponseEntity<>(postingStatusType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostingStatusType> deletePostingStatusType(@PathVariable Long id) {
        Optional<PostingStatusType> postingStatusTypeOptional = postingStatusTypeService.findById(id);
        if (!postingStatusTypeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingStatusTypeService.remove(id);
        return new ResponseEntity<>(postingStatusTypeOptional.get(), HttpStatus.NO_CONTENT);
    }

}
