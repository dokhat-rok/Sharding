package com.example.sharding.repository;

import com.example.sharding.dao.AbstractControllerDao;
import com.example.sharding.dao.DbConnectionManager;

import java.sql.SQLException;
import java.util.List;

public class UserRepository extends AbstractControllerDao<Object, Long> {

    public UserRepository(DbConnectionManager dbConnectionManager) {
        super(dbConnectionManager);
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public Object getEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }
}
