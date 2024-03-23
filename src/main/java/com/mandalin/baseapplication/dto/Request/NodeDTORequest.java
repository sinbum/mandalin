package com.mandalin.baseapplication.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NodeDTORequest {
    private Long parentNodeId;
    private Long rootId;
    private String title;
    private Integer depth;
    private Integer position;
    private String content;


    public void setContent(String content) {
        this.content = content;
    }

    // 필요한 경우, 생성자, 메서드 추가
}