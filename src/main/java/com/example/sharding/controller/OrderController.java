package com.example.sharding.controller;

import com.example.sharding.model.Order;
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
    public ResponseEntity<List<Order>> getAll() {

        return ResponseEntity.ok(List.of());
    }

    @GetMapping
    public ResponseEntity<Void> get(Long id) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {

        return  ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Order order) {

        return  ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Order order) {

        return ResponseEntity.ok().build();
    }
}
