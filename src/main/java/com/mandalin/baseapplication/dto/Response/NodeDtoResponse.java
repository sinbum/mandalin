package com.mandalin.baseapplication.dto.Response;

import com.mandalin.baseapplication.models.Node;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NodeDtoResponse {
    private Long nodeId;
    private Long parentNodeId;
    private Long rootId;
    private String title;
    private Integer depth;
    private Integer position;
    private String content;

    // 필요한 경우, 생성자, 메서드 추가

    public NodeDtoResponse(Node node) {
        this.nodeId = node.getNodeId();
        // parentNode가 null이면 parentNodeId를 0으로 설정, 그렇지 않으면 해당 parentNodeId를 설정
        this.parentNodeId = node.getParentNode() == null ? 0 : node.getParentNode().getNodeId();
        this.rootId = node.getRoot().getRootId();
        this.title = node.getTitle();
        this.depth = node.getDepth();
        this.position = node.getPosition();
        this.content = node.getContent();
    }

}