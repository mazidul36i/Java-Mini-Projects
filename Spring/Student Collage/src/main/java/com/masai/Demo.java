package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

        Collage collage = ctx.getBean("collage", Collage.class);
        collage.showDetails();

    }

}
