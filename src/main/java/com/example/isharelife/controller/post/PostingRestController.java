package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.Posting;
import com.example.isharelife.service.post.IPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posting")
public class PostingRestController {

    @Autowired
    IPostingService postingService;

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


}
