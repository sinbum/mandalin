package com.mandalin.baseapplication.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rootId;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @Builder
    public Root(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }


    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    private List<Node> nodes = new ArrayList<>();

}