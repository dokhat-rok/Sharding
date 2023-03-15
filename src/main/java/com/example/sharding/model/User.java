package com.example.sharding.model;

import lombok.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    private Long id;

    private String surname;

    private String city;
}
