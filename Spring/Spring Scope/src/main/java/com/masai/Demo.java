package com.masai;

import com.masai.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Travel travel = ctx.getBean("travel", Travel.class);

        travel.printHello();

        ctx.close();

    }
}
