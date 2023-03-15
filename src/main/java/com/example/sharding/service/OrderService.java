package com.example.sharding.service;

import com.example.sharding.model.Order;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    void get(Long id);

    void delete(Long id);

    void update(@RequestBody Order order);

    void create(@RequestBody Order order);
}
