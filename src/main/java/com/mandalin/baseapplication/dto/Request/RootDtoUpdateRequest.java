package com.mandalin.baseapplication.dto.Request;


import com.mandalin.baseapplication.models.Root;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RootDtoUpdateRequest {
    private Long rootId;
    private String title;
    private String description;

    public RootDtoUpdateRequest(Root root) {
        this.rootId = root.getRootId();
        this.title = root.getTitle();
        this.description = root.getDescription();
    }
}
