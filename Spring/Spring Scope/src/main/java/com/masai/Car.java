package com.masai;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car {

    public void print() {
        System.out.println("Print method called!");
    }

}
