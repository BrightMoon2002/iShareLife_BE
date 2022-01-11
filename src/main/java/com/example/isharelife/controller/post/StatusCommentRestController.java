package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.StatusComment;
import com.example.isharelife.service.post.IStatusCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statusComment")
public class StatusCommentRestController {

    @Autowired
    IStatusCommentService statusCommentService;

    @GetMapping
    public ResponseEntity<Iterable<StatusComment>> findAllStatusComment() {
        return new ResponseEntity<>(statusCommentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusComment> findStatusCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(statusCommentService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusComment> save(@RequestBody StatusComment statusComment) {
        statusCommentService.save(statusComment);
        return new ResponseEntity<>(statusComment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusComment> updateStatusComment(@PathVariable Long id, @RequestBody StatusComment statusComment) {
        Optional<StatusComment> statusCommentOptional=statusCommentService.findById(id);
        if (!statusCommentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusComment.setId(statusCommentOptional.get().getId());
        statusCommentService.save(statusComment);
        return new ResponseEntity<>(statusComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusComment> deleteStatusComment(@PathVariable Long id) {
        Optional<StatusComment> statusCommentOptional = statusCommentService.findById(id);
        if (!statusCommentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusCommentService.remove(id);
        return new ResponseEntity<>(statusCommentOptional.get(), HttpStatus.NO_CONTENT);
    }
}
