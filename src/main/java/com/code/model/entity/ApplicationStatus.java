package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name="application_status")

public class ApplicationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String status;
}
