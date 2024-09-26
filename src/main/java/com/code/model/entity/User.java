package com.code.model.entity;

import  jakarta.persistence.*;
import  lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;


    // Relación uno a uno con Applicant (si el usuario es aplicante)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Applicant applicant;

    // Relación uno a uno con Company (si el usuario es empleador)
  //  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // private Company company;


    // Relación muchos a uno con Role (para determinar si es aplicante, empleador o miembro)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}
