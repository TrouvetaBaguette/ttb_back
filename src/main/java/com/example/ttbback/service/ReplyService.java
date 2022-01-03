package com.example.ttbback.service;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Reply;
import com.example.ttbback.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ReplyService {
    private ReplyRepository repository;
    @Autowired
    public ReplyService(ReplyRepository repository) {
        this.repository = repository;
    }
    public Reply saveReply(Reply reply) {
        return repository.save(reply);
    }
    public Reply getReplyById(UUID id) { return repository.findById(id); }
    public void deleteReply(UUID id) {
        repository.deleteById(id);
    }
    public Reply updateReply(Reply reply){
        Reply existingReply=repository.findById(reply.getId());
        existingReply.setContent(reply.getContent());
        return repository.save(existingReply);
    }
}
