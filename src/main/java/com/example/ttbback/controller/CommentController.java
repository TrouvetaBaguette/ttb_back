package com.example.ttbback.controller;

import com.example.ttbback.entity.Bakery;
import com.example.ttbback.entity.Comment;
import com.example.ttbback.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CommentController {

    @Autowired
    private CommentService service;

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment) {
        return this.service.saveComment(comment);
    }

    @DeleteMapping("/comment/delete/{id}")
    public void deleteComment(@PathVariable UUID id) {
         this.service.deleteComment(id);
    }

    @GetMapping("/commentById/{id}")
    public Comment findCommentById(@PathVariable UUID id) {
        return this.service.getCommentById(id);
    }

    @PutMapping("/comment/update")
    public Comment updateComment(@RequestBody Comment comment) {
        return service.updateComment(comment);
    }

}

