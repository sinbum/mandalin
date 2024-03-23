package com.mandalin.baseapplication.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class NodeTagDto {
    private Long id;
    private Long nodeId;
    private Long tagId;
    // Getters and Setters will be handled by Lombok
}
