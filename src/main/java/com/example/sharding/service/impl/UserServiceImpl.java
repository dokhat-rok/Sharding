package com.example.sharding.service.impl;

import com.example.sharding.model.User;
import com.example.sharding.model.enums.City;
import com.example.sharding.repository.UserRepository;
import com.example.sharding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Map<String, UserRepository> userRepositoryMap;

    @Override
    public List<User> getAll(City city) {
        return null;
    }

    @Override
    public User get(Long id, City city) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Long id, City city) {

    }
}
