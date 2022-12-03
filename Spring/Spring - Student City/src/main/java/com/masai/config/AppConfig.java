package com.masai.config;

import com.masai.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.masai"})
public class AppConfig {

    @Bean("cities")
    public List<String> getCities(){
        List<String> cities = new ArrayList<>();
        cities.add("Guwahati");
        cities.add("Pune");
        cities.add("Mumbai");
        cities.add("Bangalore");
        cities.add("Surat");
        return cities;
    }

    @Bean("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add((new Student("Mazidul Islam", 128, 785)));
        students.add((new Student("Pablo", 43, 784)));
        students.add((new Student("Atif", 73, 844)));
        students.add((new Student("Amit", 374, 578)));
        students.add((new Student("Chunnu", 327, 657)));
        return students;
    }

}
