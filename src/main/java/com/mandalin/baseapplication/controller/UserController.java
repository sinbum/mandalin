package com.mandalin.baseapplication.controller;

import com.mandalin.baseapplication.models.User;
import com.mandalin.baseapplication.dto.Response.UserDtoResponse;
import com.mandalin.baseapplication.dto.Request.UserDtoRequest;
import com.mandalin.baseapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        List<UserDtoResponse> users = userService.getAllUsers()
                .stream()
                .map(UserDtoResponse::new)
                .toList();

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserDtoRequest userDtoRequest) {
        User user = userService.createUser(userDtoRequest);
        return ResponseEntity.ok().body(new UserDtoResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable("id") Long id) {

        User user = userService.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok()
                .body(new UserDtoResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserDtoRequest userDtoRequest) {
        User updatedUser = userService.updateUser(id, userDtoRequest);
        return ResponseEntity.ok().body(new UserDtoResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}