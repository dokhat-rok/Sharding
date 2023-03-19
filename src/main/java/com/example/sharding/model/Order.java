package com.example.sharding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

    private Long id;

    private String product;

    private Long count;

    private User user;


}
