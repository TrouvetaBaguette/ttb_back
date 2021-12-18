package com.example.ttbback.repository;

import com.example.ttbback.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>, CrudRepository<Comment, Integer> {
    void deleteById(UUID id);

    Comment findById(UUID id);

}
