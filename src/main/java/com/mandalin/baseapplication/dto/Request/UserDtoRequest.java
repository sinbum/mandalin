package com.mandalin.baseapplication.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoRequest {
    private String username;
    private String password;
    private String email;
}