package com.masai;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
// PreDestroy won't own on prototype scope
//@Scope(scopeName = "prototype")
public class Travel {

    public void printHello() {
        System.out.println("Hello, Traveler!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Travel bean initialized!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Closed travel class");
    }

}
