package com.example.ttbback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id_comment;
    UUID id_client;
    UUID id_bakery;
    UUID id_product;
    String nameProduct;
    String note;
    String content;
    String title;
    Date date;
    Boolean ifReply;


}
