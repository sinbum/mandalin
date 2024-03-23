package com.mandalin.baseapplication.service;

import java.util.List;

import com.mandalin.baseapplication.models.Root;
import com.mandalin.baseapplication.models.User;
import com.mandalin.baseapplication.dto.Request.RootDtoRequest;
import com.mandalin.baseapplication.dto.Request.RootDtoUpdateRequest;
import com.mandalin.baseapplication.repository.RootRepository;
import com.mandalin.baseapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootService {

    @Autowired
    private RootRepository rootRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Root> findAllRoots() {
        return rootRepository.findAll();
    }

    public Root findRootById(Long id) {
        return rootRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id))
                ;
    }

    public Root updatedRoot(RootDtoUpdateRequest dto) {
        Root root = this.findRootById(dto.getRootId());

        root.setTitle(dto.getTitle());
        root.setDescription(dto.getDescription());

        return rootRepository.save(root);
    }

    public Root saveRoot(RootDtoRequest dto) {
        Long userId = dto.getUserId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId.toString())); // 존재하지 않는 경우 예외 처리


        Root root = Root.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .user(user) // Root 엔티티에 User 설정
                .build();

        return rootRepository.save(root);
    }

    public void deleteRoot(Long id) {
        rootRepository.deleteById(id);
    }
}