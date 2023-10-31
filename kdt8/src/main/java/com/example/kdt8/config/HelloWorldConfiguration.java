package com.example.kdt8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//record : getter, setter, 생성자 등 자동으로 생성
record Person(String name, int age) {}
record Address(String address, int postcode) {}

record Infomation(String name, int age, Address address) {}
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

    @Bean
    public Person person() {
        return new Person("홍길동", 20);
    }

    @Bean(name = "myAddress")
    public Address address() {
        return new Address("서울시 마포구", 12345);
    }
    @Bean
    public Infomation info(String name, int age, Address myAddress) {
        return new Infomation(name, age, myAddress);
    }

    @Bean
    @Primary //같은 record를 같는 bean이 있을 경우(class로 접근할 때) 명시
    public Address address2() {
        return new Address("seoul mapo", 45678);
    }
}
