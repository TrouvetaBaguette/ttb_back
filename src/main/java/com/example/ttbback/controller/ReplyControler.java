package com.example.ttbback.controller;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Reply;
import com.example.ttbback.service.CommentService;
import com.example.ttbback.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public class ReplyControler {

    @Autowired
    private ReplyService service;

    @PostMapping("/addReply")
    public Reply addComment(@RequestBody Reply reply) {
        // appeler findById de comment
        // faire un set de if reply
        //updates de ce nouveau comment
        
        return this.service.saveReply(reply);
    }

    @DeleteMapping("/reply/delete/{id}")
    public void deleteReply(@PathVariable UUID id) {
        this.service.deleteReply(id);
    }

    @GetMapping("/replyById/{id}")
    public Reply findReplyById(@PathVariable UUID id) {
        return this.service.getReplyById(id);
    }

    @PutMapping("/reply/update")
    public Reply updateReply(@RequestBody Reply reply) {
        return service.updateReply(reply);
    }

}
