package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "companies")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

   // @OneToOne
   // @JoinColumn(name = "user_id", referencedColumnName = "id")
   // private User user;
}
