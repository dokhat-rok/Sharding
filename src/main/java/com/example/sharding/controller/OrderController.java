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

        return ResponseEntity.ok(List.of());
    }

    @GetMapping
    public ResponseEntity<Void> get(@RequestParam Long id, @RequestParam City city) {

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Order order, @RequestParam City city) {

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Order order, @RequestParam City city) {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id, @RequestParam City city) {

        return ResponseEntity.ok().build();
    }
}
