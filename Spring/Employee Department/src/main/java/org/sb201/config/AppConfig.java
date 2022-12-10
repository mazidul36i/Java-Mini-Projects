package org.sb201.config;

import org.sb201.Department;
import org.sb201.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"org.sb201"})
public class AppConfig {

    @Bean("empDept")
    public Map<Department, Employee> getMap() {
        Map<Department, Employee> theMap = new HashMap<>();
        theMap.put(new Department(1, "Sales", "Assam"), new Employee(1, "Shubham", "Ghy", 80000));
        theMap.put(new Department(2, "Marketing", "Mumbai"), new Employee(2, "Bhoskar", "Pune", 75489));
        theMap.put(new Department(3, "Accounts", "Chennai"), new Employee(3, "Pablo", "Surat", 85344));
        return theMap;
    }

}
