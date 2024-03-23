package com.mandalin.baseapplication.controller;

import com.mandalin.baseapplication.dto.Request.NodeDTORequest;
import com.mandalin.baseapplication.dto.Response.NodeDtoResponse;
import com.mandalin.baseapplication.models.Node;
import com.mandalin.baseapplication.service.NodeServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {

    @Autowired
    private NodeServiceImpl nodeService;

    @GetMapping
    public ResponseEntity<List<NodeDtoResponse>> getAllNodes() {
        List<NodeDtoResponse> nodes = nodeService.getAllNodes()
                .stream()
                .map(NodeDtoResponse::new) // NodeDtoResponse 생성자에서 Node 엔터티를 DTO로 변환
                .toList();
        return ResponseEntity.ok().body(nodes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NodeDtoResponse> getNodeById(@PathVariable("id") Long id) {
        Node node = nodeService.getNodeById(id)
                .orElseThrow(() -> new EntityNotFoundException("Node not found with id: " + id));
        return ResponseEntity.ok(new NodeDtoResponse(node));
    }

    @PostMapping
    public ResponseEntity<NodeDtoResponse> createNode(@RequestBody NodeDTORequest nodeDtoRequest) {
        Node node = nodeService.saveNode(nodeDtoRequest);
        return ResponseEntity.ok(new NodeDtoResponse(node));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NodeDtoResponse> updateNode(@PathVariable("id") Long id, @RequestBody NodeDTORequest nodeDTORequest) {
        Node node = nodeService.updateNode(id, nodeDTORequest);
        return ResponseEntity.ok(new NodeDtoResponse(node));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNode(@PathVariable("id") Long id) {
        nodeService.deleteNode(id);
        return ResponseEntity.ok().build();
    }
}