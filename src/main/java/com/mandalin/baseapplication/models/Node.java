package com.mandalin.baseapplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nodeId;

    @ManyToOne
    @JoinColumn(name = "parentNodeId")
    private Node parentNode;

    @ManyToOne
    @JoinColumn(name = "rootId", nullable = false)
    @JsonBackReference
    private Root root;

    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private Integer depth;

    @Column(nullable = false)
    private Integer position;

    @Column()
    @Lob
    private String content;

//    @ManyToMany
//    @JoinTable(
//            name = "node_tag",
//            joinColumns = @JoinColumn(name = "nodeId"),
//            inverseJoinColumns = @JoinColumn(name = "tagId")
//    )

//    private List<Tag> tags = new ArrayList<>();


    @Builder
    public Node(String title, Integer depth, Integer position, Root root, Node parentNode, String content) {
        this.title = title;
        this.depth = depth;
        this.position = position;
        this.root = root;
        this.parentNode = parentNode;
        this.content = content;
    }


}


