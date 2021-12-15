package com.example.ttbback.service;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Reply;
import com.example.ttbback.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.UUID;

public class CommentService {


    private CommentRepository repository;

    @Autowired
    public CommentService(com.example.ttbback.repository.CommentRepository repository) {
        this.repository = repository;
    }

    public Comment saveComment(Comment comment) {
        return repository.save(comment);
    }

    public Comment getCommentById(UUID id) { return repository.findById(id); }

    public Reply getReply(UUID id) { return repository.findReply(id); }

    public void deleteComment(UUID id) {
        repository.deleteById(id);
    }

    public Comment updateBakery(Comment comment){
        Comment existingComment=repository.findById(comment.getId_comment());
        existingComment.setId_bakery(comment.getId_bakery());
        existingComment.setId_client(comment.getId_client());
        existingComment.setId_product(comment.getId_product());
        existingComment.setNameProduct(comment.getNameProduct());
        existingComment.setNote(comment.getNote());
        existingComment.setContent(comment.getContent());
        existingComment.setTitle(comment.getTitle());
        existingComment.setDate(comment.getDate());
        existingComment.setIfReply(comment.getIfReply());
        return repository.save(existingComment);
    }


}
