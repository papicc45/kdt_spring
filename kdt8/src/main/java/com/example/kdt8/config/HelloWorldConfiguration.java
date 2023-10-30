package com.example.kdt8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//record : getter, setter, 생성자 등 자동으로 생성
record Person(String name, int age) {}
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "KDT8";
    }

    @Bean
    public int age() {
        return 30;
    }
}
