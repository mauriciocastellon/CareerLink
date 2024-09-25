package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdAt;

    @Column(name = "is_private")
    private boolean isPrivate;
}
