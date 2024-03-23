package com.mandalin.baseapplication.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private ProfilePicture profilePicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Root> roots;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}