package com.mandalin.baseapplication.service;

import com.mandalin.baseapplication.dto.Request.NodeDTORequest;
import com.mandalin.baseapplication.models.Node;

import java.util.List;
import java.util.Optional;

public interface NodeService {

    List<Node> getAllNodes();

    Optional<Node> getNodeById(Long id);

    Node saveNode(NodeDTORequest nodeDto);

    Node updateNode(Long id, NodeDTORequest nodeDto);

    void deleteNode(Long id);
}