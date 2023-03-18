package com.example.sharding.controller;

import com.example.sharding.model.Order;
import com.example.sharding.model.enums.City;
import com.example.sharding.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@Validated
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(@RequestParam City city) {
        List<Order> orders = orderService.getAll(city);
        log.info("Get all orders by city:{}",city);
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    public ResponseEntity<Order> get(@RequestParam Long id, @RequestParam City city) {
        Order order = orderService.get(id,city);
        log.info("Get order with id: {} by city: {}",id,city);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order, @RequestParam City city) {
        Order orderNew = orderService.create(order, city);
        log.info("Create new order: {} by city:{}",orderNew,city);
        return ResponseEntity.ok(orderNew);
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order, @RequestParam City city) {
        Order orderUpdate = orderService.update(order,city);
        log.info("Update order: {} by city:{}",orderUpdate,city);
        return ResponseEntity.ok(orderUpdate);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id, @RequestParam City city) {
        orderService.delete(id,city);
        log.info("Delete order with id: {} by city:{}",id,city);
        return ResponseEntity.ok().build();
    }
}
