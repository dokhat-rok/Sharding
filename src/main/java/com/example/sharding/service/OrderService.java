package com.example.sharding.service;

import com.example.sharding.model.Order;
import com.example.sharding.model.enums.City;

import java.util.List;

public interface OrderService {

    List<Order> getAll(City city);

    Order get(Long id, City city);

    Order create(Order order, City city);

    Order update(Order order, City city);

    void delete(Long id, City city);
}
