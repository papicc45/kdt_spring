package com.example.spring_mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PracUser {
    private long id;
    private String userId;
    private String password;

    private String name;
}
