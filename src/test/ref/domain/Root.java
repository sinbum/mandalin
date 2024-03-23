package com.mandalin.baseapplication.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rootId;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    private List<Node> nodes = new ArrayList<>();
}