package org.sb201;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

@Component
class Demo {

    @Autowired
    @Qualifier("empDept")
    private Map<Department, Employee> theMap;

    @PostConstruct
    public void myInit() {
        System.out.println("inside myInit method");
    }

    @PreDestroy
    @Lazy
    public void cleanUp() {
        System.out.println("\ninside cleanUp method");
    }

    public void showDetails() {
        System.out.println("\ninside showDetails of Demo class");

        theMap.forEach((dept, employee) -> {
            System.out.println("===================================");
            System.out.println(dept);
            System.out.println(employee);
        });
    }
}