package com.mandalin.baseapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String email;
}