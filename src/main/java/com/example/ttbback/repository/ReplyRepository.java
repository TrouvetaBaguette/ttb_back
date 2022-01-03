package com.example.ttbback.repository;

import com.example.ttbback.entity.Comment;
import com.example.ttbback.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReplyRepository extends JpaRepository<Reply,Integer>, CrudRepository<Reply, Integer> {
    void deleteById(UUID id);

    Reply findById(UUID id);

}
