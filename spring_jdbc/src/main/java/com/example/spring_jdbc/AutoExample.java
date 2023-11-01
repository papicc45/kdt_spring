package com.example.spring_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
class AutowiredExample {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}

@RestController
public class AutoExample {
    private final AutowiredExample autowiredExample;

    @Autowired
    public AutoExample(AutowiredExample autowiredExample) {
        this.autowiredExample = autowiredExample;
    }

    @GetMapping("/hello")
    public String hello() {
        return autowiredExample.sayHello("이동준");
    }
}
