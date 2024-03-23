package com.mandalin.baseapplication.service;

import com.mandalin.baseapplication.dto.Request.NodeDTORequest;
import com.mandalin.baseapplication.models.Node;
import com.mandalin.baseapplication.models.Root;
import com.mandalin.baseapplication.repository.NodeRepository;
import com.mandalin.baseapplication.repository.RootRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private RootRepository rootRepository;

    @Override
    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }

    @Override
    public Optional<Node> getNodeById(Long id) {
        return nodeRepository.findById(id);
    }

    @Override
    public Node saveNode(NodeDTORequest dto) {
        Long rootId = dto.getRootId();
        Root root = rootRepository.findById(rootId)
                .orElseThrow(() -> new EntityNotFoundException("Root not found with id " + rootId));

        // parentNodeId가 0이라면, 이를 null로 처리하여 최상위 노드임을 나타낸다.
        Long parentNodeId = dto.getParentNodeId();
        Node parentNode = null;

        // parentNodeId가 null이 아니라면, 해당하는 노드를 찾는다.
        if (parentNodeId != null) {
            parentNode = nodeRepository.findById(parentNodeId)
                    .orElseThrow(() -> new EntityNotFoundException("Parent node not found with id " + parentNodeId));
        }

        // parentNode는 null일 수도, 특정 노드를 가리킬 수도 있다.
        Node node = Node.builder()
                .title(dto.getTitle())
                .depth(dto.getDepth())
                .position(dto.getPosition())
                .root(root)
                .parentNode(parentNode)
                .content(dto.getContent())
                .build();

        // Node 엔터티 저장
        return nodeRepository.save(node);
    }

    @Override
    public Node updateNode(Long nodeId, NodeDTORequest dto) {

        // 노드 ID로 기존 노드 찾기
        Node node = nodeRepository.findById(nodeId)
                .orElseThrow(() -> new EntityNotFoundException("Node not found with id " + nodeId));

        // Root 정보 업데이트 (필요한 경우)
        Long rootId = dto.getRootId();
        Root root = rootRepository.findById(rootId)
                .orElseThrow(() -> new EntityNotFoundException("Root not found with id " + rootId));
        node.setRoot(root);

        // parentNodeId가 0이라면, 이를 null로 처리하여 최상위 노드임을 나타낸다.
        Long parentNodeId = dto.getParentNodeId() != null && dto.getParentNodeId() == 0 ? null : dto.getParentNodeId();
        if (parentNodeId != null) {
            Node parentNode = nodeRepository.findById(parentNodeId)
                    .orElseThrow(() -> new EntityNotFoundException("Parent node not found with id " + parentNodeId));
            node.setParentNode(parentNode);
        } else {
            node.setParentNode(null); // 최상위 노드로 설정
        }

        // 다른 속성들 업데이트
        node.setTitle(dto.getTitle());
        node.setDepth(dto.getDepth());
        node.setPosition(dto.getPosition());
        node.setContent(dto.getContent());

        // 업데이트된 노드 저장
        return nodeRepository.save(node);
    }

    @Override
    public void deleteNode(Long id) {
        nodeRepository.deleteById(id);
    }
}
