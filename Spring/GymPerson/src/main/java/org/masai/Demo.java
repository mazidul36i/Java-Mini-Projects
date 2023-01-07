package org.masai;

import org.masai.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService personService = ctx.getBean("personService", PersonService.class);

        System.out.println("\n************** Printing The Map *************");
        personService.printMap();
        System.out.println("\n************** Printing The Person List *************");
        personService.printList();
        System.out.println("\n************** App Name *************");
        personService.printAppName();
    }
}