package com.example.sharding.repository;

import com.example.sharding.dao.AbstractControllerDao;
import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.model.User;

import java.util.List;

public class UserRepository extends AbstractControllerDao<User, Long> {

    public UserRepository(DbConnectionManager dbConnectionManager) {
        super(dbConnectionManager);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
