package com.example.sharding.controller;

import com.example.sharding.model.User;
import com.example.sharding.service.OrderService;
import com.example.sharding.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@Validated
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {

        return ResponseEntity.ok(List.of());
    }

    @GetMapping
    public ResponseEntity<Void> get(Long id) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {

        return  ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody User user) {

        return  ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {

        return ResponseEntity.ok().build();
    }
}
