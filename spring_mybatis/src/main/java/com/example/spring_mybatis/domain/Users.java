package com.example.spring_mybatis.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    private long id;
    private String name;
    private String address;
}
