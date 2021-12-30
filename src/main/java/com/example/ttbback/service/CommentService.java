package com.example.ttbback.service;

import com.example.ttbback.entity.Bakery;
import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Reply;
import com.example.ttbback.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
public class CommentService {

    private CommentRepository repository;
    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }
    public Comment saveComment(Comment comment) {
        return repository.save(comment);
    }
    public Comment getCommentById(UUID id_comment) { return repository.findById(id_comment); }
    public Comment getCommentByIdProduct(UUID id_product){return repository.findbyIDProdut(id_product);}
    public void deleteComment(UUID id) {
        repository.deleteById(id);
    }
    public Comment updateComment(Comment comment){
        Comment existingComment=repository.findById(comment.getId());
        existingComment.setId_product(comment.getId_product());
        existingComment.setId_client(comment.getId_client());
        existingComment.setId_bakery(comment.getId_bakery());
        existingComment.setDate(comment.getDate());
        existingComment.setIfReply(comment.getIfReply());
        existingComment.setId(comment.getId());
        existingComment.setContent(comment.getContent());
        existingComment.setNote(comment.getNote());
        existingComment.setTitle(comment.getTitle());
        existingComment.setNameProduct(comment.getNameProduct());
        return repository.save(existingComment);
    }

}
