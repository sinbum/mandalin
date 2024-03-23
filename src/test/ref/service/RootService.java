package com.mandalin.baseapplication.service;

import java.util.List;
import java.util.Optional;

import com.mandalin.baseapplication.domain.Root;
import com.mandalin.baseapplication.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootService {

    @Autowired
    private RootRepository rootRepository;

    public List<Root> findAllRoots() {
        return rootRepository.findAll();
    }

    public Optional<Root> findRootById(Long id) {
        return rootRepository.findById(id);
    }

    public Root saveRoot(Root root) {
        return rootRepository.save(root);
    }

    public void deleteRoot(Long id) {
        rootRepository.deleteById(id);
    }
}