package com.mandalin.baseapplication.service;

import com.mandalin.baseapplication.domain.NodeTag;
import com.mandalin.baseapplication.domain.NodeTagId;
import com.mandalin.baseapplication.repository.NodeTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NodeTagService {

    private final NodeTagRepository nodeTagRepository;

    @Autowired
    public NodeTagService(NodeTagRepository nodeTagRepository) {
        this.nodeTagRepository = nodeTagRepository;
    }

    public List<NodeTag> findAll() {
        return nodeTagRepository.findAll();
    }

    public NodeTag save(NodeTag nodeTag) {
        return nodeTagRepository.save(nodeTag);
    }

    public void delete(NodeTagId nodeTagId) {
        nodeTagRepository.deleteById(nodeTagId);
    }

    // Additional methods for update and other business logic
}