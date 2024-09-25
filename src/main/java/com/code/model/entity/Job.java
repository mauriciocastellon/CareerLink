package com.code.model.entity;

import  jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table (name = "jobs")
public class Job {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "job_type", nullable = false)
    private String jobType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "salary_range")
    private Double salaryRange;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_jobs_companies"))
    private Company company;
}
