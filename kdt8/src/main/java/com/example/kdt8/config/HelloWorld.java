package com.example.kdt8.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {

    public static void main(String[] args) {
        //스프링 컨텍스트를 실행하는 단계
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //스프링 프레임워크가 관리하도록 설정
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("myAddress"));
        System.out.println(context.getBean("info"));
        System.out.println(context.getBean(Infomation.class));
        //2개 이상의 bean 값이 존재할 경우, @Primary 어노테이션 명시한 것 만 가져옴
        System.out.println(context.getBean(Address.class));

        String[] beans = context.getBeanDefinitionNames();
        for(String name : beans) {
            System.out.println(name);
        }

    }
}
