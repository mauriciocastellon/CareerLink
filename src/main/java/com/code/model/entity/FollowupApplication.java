package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "follow_up_applications")
public class FollowupApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(name = "qualification_id", nullable = false)
    private String qualificationId;
}
