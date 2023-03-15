package com.example.sharding.service;

import com.example.sharding.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void get(Long id);

    void delete(Long id);

    void update(@RequestBody User user);

    void create(@RequestBody User user);
}
