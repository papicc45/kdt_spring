package com.example.kdt8.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(title = "kdt8_spring",
        description = "스프링부트 api",
        version = "v1")
)
public class SwaggerConfiguration {

}
