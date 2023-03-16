package com.example.sharding.controller;

import com.example.sharding.model.User;
import com.example.sharding.model.enums.City;
import com.example.sharding.service.UserService;
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
    public ResponseEntity<List<User>> getAll(@RequestParam City city) {

        return ResponseEntity.ok(List.of());
    }

    @GetMapping
    public ResponseEntity<User> get(@RequestParam Long id, @RequestParam City city) {

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id, @RequestParam City city) {

        return ResponseEntity.ok().build();
    }
}
