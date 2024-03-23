package com.mandalin.baseapplication.repository;

import com.mandalin.baseapplication.domain.NodeTag;
import com.mandalin.baseapplication.domain.NodeTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeTagRepository extends JpaRepository<NodeTag, NodeTagId> {
    // Custom query methods if needed
}