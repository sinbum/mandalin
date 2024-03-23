package com.mandalin.baseapplication.repository;

import com.mandalin.baseapplication.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
}
