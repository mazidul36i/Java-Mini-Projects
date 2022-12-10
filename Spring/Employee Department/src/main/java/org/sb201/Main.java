package org.sb201;

import org.sb201.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Demo demo = ctx.getBean("demo", Demo.class);

        demo.showDetails();
        ctx.close();
    }

}