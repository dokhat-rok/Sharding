package com.example.sharding.repository;

import com.example.sharding.dao.AbstractControllerDao;
import com.example.sharding.dao.DbConnectionManager;
import com.example.sharding.model.Order;

import java.util.List;

public class OrderRepository extends AbstractControllerDao<Order, Long> {

    public OrderRepository(DbConnectionManager dbConnectionManager) {
        super(dbConnectionManager);
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order get(Long id) {
        return null;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
