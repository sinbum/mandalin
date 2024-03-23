package com.mandalin.baseapplication.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "tags")
    private List<Node> nodes = new ArrayList<>();
}
