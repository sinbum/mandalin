package com.mandalin.baseapplication.dto.Response;

import com.mandalin.baseapplication.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoResponse {
    private Long id;
    private String username;
    private String email;


    public UserDtoResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

}