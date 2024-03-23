package com.mandalin.baseapplication.dto.Response;

import com.mandalin.baseapplication.models.Root;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootDtoResponse {
    private Long rootId;
    private String titile;
    private String description;

    public RootDtoResponse(Root root){
        this.rootId = root.getRootId();
        this.titile = root.getTitle();
        this.description = root.getDescription();
    }

}
