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
        List<User> users = userService.getAll(city);
        log.info("Get all users by city {}: {}",city.name(),users);
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<User> get(@RequestParam Long id, @RequestParam City city) {
        User user = userService.get(id,city);
        log.info("Get user by city {}: {}",city.name(),user);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User userNew = userService.create(user);
        log.info("Create user: {}",userNew);
        return ResponseEntity.ok(userNew);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User userUpdate = userService.update(user);
        log.info("Update user: {}",userUpdate);
        return ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id, @RequestParam City city) {
         userService.delete(id, city);
        log.info("Delete user with id: {} from city: {}",id,city);
        return ResponseEntity.ok().build();
    }
}
