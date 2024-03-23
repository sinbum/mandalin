package com.mandalin.baseapplication.dto.Request;

import com.mandalin.baseapplication.models.Root;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RootDtoRequest {
    private Long userId;
    private String title;
    private String description;

    // Constructor, Getters, and Setters

    public RootDtoRequest(Root root) {
        this.userId = root.getRootId();
        this.title = root.getTitle();
        this.description = root.getDescription();
    }
}