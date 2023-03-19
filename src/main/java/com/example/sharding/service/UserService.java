package com.example.sharding.service;

import com.example.sharding.model.User;
import com.example.sharding.model.enums.City;

import java.util.List;

public interface UserService {

    List<User> getAll(City city);

    User get(Long id, City city);

    User create(User user);

    User update(User user);

    void delete(Long id, City city);
}
