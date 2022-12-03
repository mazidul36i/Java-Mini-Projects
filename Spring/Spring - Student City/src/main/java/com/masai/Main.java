package com.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class Main {

    @Autowired
    @Qualifier("cities")
    List<String> cities;

    @Autowired
    @Qualifier("students")
    List<Student> students;

    public Main() {
    }

    @PostConstruct
    public void postCreate() {
        System.out.println("Post create !");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre Destroy!");
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
