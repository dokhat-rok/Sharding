package com.example.sharding.service.impl;

import com.example.sharding.model.Order;
import com.example.sharding.model.enums.City;
import com.example.sharding.repository.OrderRepository;
import com.example.sharding.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final Map<String, OrderRepository> orderRepositoryMap;

    @Override
    public List<Order> getAll(City city) {
        return null;
    }

    @Override
    public Order get(Long id, City city) {
        return null;
    }

    @Override
    public Order create(Order order, City city) {
        return null;
    }
    @Override
    public Order update(Order order, City city) {
        return null;
    }

    @Override
    public void delete(Long id, City city) {

    }
}
