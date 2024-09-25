package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "comments")

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createdAt;

    @Column(name = "likes_count")
    private Integer likesCount;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id"
            ,foreignKey = @ForeignKey(name = "FK_comments_members"))
    private Member member;
}
