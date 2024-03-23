package com.mandalin.baseapplication.controller;

import com.mandalin.baseapplication.domain.NodeTag;
import com.mandalin.baseapplication.domain.NodeTagId;
import com.mandalin.baseapplication.service.NodeTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/nodeTags")
public class NodeTagController {

    private final NodeTagService nodeTagService;

    @Autowired
    public NodeTagController(NodeTagService nodeTagService) {
        this.nodeTagService = nodeTagService;
    }

    @GetMapping
    public ResponseEntity<List<NodeTag>> getAllNodeTags() {
        return ResponseEntity.ok(nodeTagService.findAll());
    }

    @PostMapping
    public ResponseEntity<NodeTag> createNodeTag(@RequestBody NodeTag nodeTag) {
        return ResponseEntity.ok(nodeTagService.save(nodeTag));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNodeTag(@RequestBody NodeTagId nodeTagId) {
        nodeTagService.delete(nodeTagId);
        return ResponseEntity.ok().build();
    }

    // PUT mapping for updates if necessary
}