package com.masai.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
@ComponentScan(basePackages = {"com.masai"})
public class AppConfig {

    @PreDestroy
    public void hello() {
        System.out.println("Closed AppConfig!");
    }
}
