package com.mandalin.baseapplication.controller;

import com.mandalin.baseapplication.models.Root;
import com.mandalin.baseapplication.dto.Request.RootDtoUpdateRequest;
import com.mandalin.baseapplication.dto.Response.RootDtoResponse;
import com.mandalin.baseapplication.dto.Request.RootDtoRequest;
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
    public ResponseEntity<List<RootDtoResponse>> getAllRoots() {
        List<RootDtoResponse> roots = rootService.findAllRoots()
                .stream()
                .map(RootDtoResponse::new)
                .toList();
        return ResponseEntity.ok(roots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RootDtoRequest> getRootById(@PathVariable("id") Long id) {
        Root root = rootService.findRootById(id);

        return ResponseEntity.ok()
                .body(new RootDtoRequest(root));
    }

    @PostMapping
    public ResponseEntity<RootDtoResponse> createRoot(@RequestBody RootDtoRequest rootDtoRequest) {

        Root root = rootService.saveRoot(rootDtoRequest);

        return ResponseEntity.ok().body(new RootDtoResponse(root));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RootDtoResponse> updateRoot(@RequestBody RootDtoUpdateRequest dto) {

        Root root = rootService.updatedRoot(dto);
        return ResponseEntity.ok().body(new RootDtoResponse(root));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoot(@PathVariable("id") Long id) {
        rootService.deleteRoot(id);
        return ResponseEntity.ok().build();
    }
}