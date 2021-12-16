package com.example.ttbback.controller;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Reply;
import com.example.ttbback.service.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@CrossOrigin(origins = "http://localhost:5050")
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

    //@GetMapping("/replyById/{id}")
    //public Reply findReply(@PathVariable UUID id) {
    //    return service.getReply(id);
    //}
}
