package com.mandalin.baseapplication.service;

import com.mandalin.baseapplication.domain.User;
import com.mandalin.baseapplication.dto.UserDto;
import com.mandalin.baseapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, UserDto userDto) {
        // 데이터베이스에서 해당 ID의 User를 찾습니다.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // 찾은 User 엔티티의 필드를 업데이트합니다.
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        // 변경된 엔티티를 저장하고 반환합니다.
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}