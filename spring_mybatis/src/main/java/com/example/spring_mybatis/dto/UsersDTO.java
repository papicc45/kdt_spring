package com.example.spring_mybatis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsersDTO {
    private long id;
    private String name;
    private String address;
}
