package com.example.spring_mybatis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PracUserDTO {
    private long id;
    private String userId;
    private String password;

    private String name;
}
