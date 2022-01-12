package com.example.isharelife.controller.post;

import com.example.isharelife.model.post.PostingComment;
import com.example.isharelife.model.post.PostingImage;
import com.example.isharelife.service.post.IPostingImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/postingImage")
public class PostingImageRestController {

    @Autowired
    IPostingImageService postingImageService;

    @GetMapping
    public ResponseEntity<Iterable<PostingImage>> findAllPostingImage() {
        return new ResponseEntity<>(postingImageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostingImage> findPostingImageById(@PathVariable Long id) {
        return new ResponseEntity<>(postingImageService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostingImage> save(@RequestBody PostingImage postingComment) {
        postingImageService.save(postingComment);
        return new ResponseEntity<>(postingComment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostingImage> updatePostingImage(@PathVariable Long id, @RequestBody PostingImage postingImage) {
        Optional<PostingImage> postingImageOptional=postingImageService.findById(id);
        if (!postingImageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingImage.setId(postingImageOptional.get().getId());
        postingImageService.save(postingImage);
        return new ResponseEntity<>(postingImage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostingImage> deletePostingComment(@PathVariable Long id) {
        Optional<PostingImage> postingImageOptional = postingImageService.findById(id);
        if (!postingImageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postingImageService.remove(id);
        return new ResponseEntity<>(postingImageOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/posting/{id}")
    public ResponseEntity<List<String>> findAllUrlByPostingId(@PathVariable Long id) {
        List<String> postingImageList = postingImageService.findAllByPostingId(id);
        return new ResponseEntity<>(postingImageList, HttpStatus.OK);
    }
}
