package com.mandalin.baseapplication.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "node_tag")
@IdClass(NodeTagId.class)
@Getter
@Setter
public class NodeTag {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nodeId")
    private Node node;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tagId")
    private Tag tag;

    // Constructors, getters, setters
}
