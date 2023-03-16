package com.example.sharding.model.enums;

import lombok.Getter;

@Getter
public enum City {

    ROSTOV("rostovUserRepository", "rostovOrderRepository"),

    MOSCOW("moscowUserRepository", "moscowOrderRepository"),

    BIYSK("biyskUserRepository", "biyskOrderRepository");

    private final String userRepositoryName;

    private final String orderRepositoryName;

    City(String userRepositoryName, String orderRepositoryName){
        this.userRepositoryName = userRepositoryName;
        this.orderRepositoryName = orderRepositoryName;
    }
}
