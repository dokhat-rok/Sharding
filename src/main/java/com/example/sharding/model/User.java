package com.example.sharding.model;

import com.example.sharding.model.enums.City;
import com.example.sharding.model.enums.UserStatus;
import lombok.*;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    private Long id;

    private String login;

    private City city;

    private UserStatus status;
}
