package com.code.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "is_admin")
    private Boolean isAdmin;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "Fk_members_users"))
    private User user;
}
