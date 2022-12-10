package com.masai.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Employee;
import java.util.*;

@RestController
public class MyController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Welcome to Spring Boot";
	}
	
	
	@RequestMapping("/employee")
	public Employee getEmployee() {
		Employee emp = new Employee(1, "Pablo", "Ghy", 75893);
		return emp;
	}
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Pablo", "Ghy", 75893));
		employees.add(new Employee(2, "Amit", "Pune", 65473));
		employees.add(new Employee(3, "Panday", "Bangalore", 54364));
		employees.add(new Employee(4, "Rahul", "Delhi", 64523));
		employees.add(new Employee(5, "Ratan", "Bihar", 43256));
		return employees;
	}
	
}
