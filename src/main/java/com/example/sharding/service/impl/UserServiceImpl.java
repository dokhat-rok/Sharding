package com.example.sharding.service.impl;

import com.example.sharding.exception.DataSourceException;
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
        return this.getRepository(city).getAll();
    }

    @Override
    public User get(Long id, City city) {
        return this.getRepository(city).get(id);
    }

    @Override
    public User create(User user) {
        return this.getRepository(user.getCity()).create(user);
    }

    @Override
    public User update(User user) {
        return this.getRepository(user.getCity()).update(user);
    }

    @Override
    public void delete(Long id, City city) {
        this.getRepository(city).delete(id);
    }

    private UserRepository getRepository(City city){
        UserRepository userRepository = userRepositoryMap.get(city.getUserRepositoryName());
        if(userRepository == null) throw new DataSourceException(city.name() + " database not available");
        return userRepository;
    }
}
