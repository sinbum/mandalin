package com.mandalin.baseapplication.dto.Response;

import com.mandalin.baseapplication.models.Root;
import com.mandalin.baseapplication.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDtoResponse {
    private Long id;
    private String username;
    private String email;
    private List<Root> roots;


    public UserDtoResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roots = user.getRoots();
    }

}