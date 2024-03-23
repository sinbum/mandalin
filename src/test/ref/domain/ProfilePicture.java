package com.mandalin.baseapplication.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProfilePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pictureId;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private LocalDateTime uploadedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
