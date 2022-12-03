package com.masai;

import com.masai.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Main main = ctx.getBean("main", Main.class);

        List<String> cities = main.getCities();
        List<Student> students = main.getStudents();

        System.out.println("========================== Cities =======================");
        cities.forEach(System.out::println);
        System.out.println("========================== Students =======================");
        students.forEach(System.out::println);

        System.out.println();


    }

}
