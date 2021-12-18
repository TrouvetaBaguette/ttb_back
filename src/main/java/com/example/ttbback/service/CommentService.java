package com.example.ttbback.service;

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
    public void deleteComment(UUID id) {
        repository.deleteById(id);
    }

}
