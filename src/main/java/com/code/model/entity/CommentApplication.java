package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comments_application")
public class CommentApplication {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "author", nullable = false)
    private String author;
}
