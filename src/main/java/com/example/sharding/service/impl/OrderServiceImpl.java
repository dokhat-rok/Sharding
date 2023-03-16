package com.example.sharding.service.impl;

import com.example.sharding.exception.DataSourceException;
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
        return this.getRepository(city).getAll();
    }

    @Override
    public Order get(Long id, City city) {
        return this.getRepository(city).get(id);
    }

    @Override
    public Order create(Order order, City city) {
        return this.getRepository(city).create(order);
    }
    @Override
    public Order update(Order order, City city) {
        return this.getRepository(city).update(order);
    }

    @Override
    public void delete(Long id, City city) {
        this.getRepository(city).delete(id);
    }

    private OrderRepository getRepository(City city){
        OrderRepository orderRepository = orderRepositoryMap.get(city.getOrderRepositoryName());
        if(orderRepository == null) throw new DataSourceException(city.name() + " database not available");
        return orderRepository;
    }
}
