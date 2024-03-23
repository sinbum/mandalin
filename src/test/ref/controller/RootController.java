package com.mandalin.baseapplication.controller;

import com.mandalin.baseapplication.domain.Root;
import com.mandalin.baseapplication.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roots")
public class RootController {

    @Autowired
    private RootService rootService;

    @GetMapping
    public ResponseEntity<List<Root>> getAllRoots() {
        return ResponseEntity.ok(rootService.findAllRoots());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Root> getRootById(@PathVariable Long id) {
        return rootService.findRootById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Root> createRoot(@RequestBody Root root) {
        return ResponseEntity.ok(rootService.saveRoot(root));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Root> updateRoot(@PathVariable Long id, @RequestBody Root root) {
        return rootService.findRootById(id)
                .map(existingRoot -> {
                    root.setRootId(existingRoot.getRootId());
                    return ResponseEntity.ok(rootService.saveRoot(root));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoot(@PathVariable Long id) {
        rootService.deleteRoot(id);
        return ResponseEntity.ok().build();
    }
}