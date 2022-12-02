package com.em.usecases;

import com.em.bean.Employee;
import com.em.dao.EmployeeDao;
import com.em.dao.EmployeeDaoImpl;
import com.em.exceptions.EmployeeException;

import java.util.Scanner;

public class RegisterEmployee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.println("Enter employee name: ");
//        sc.nextLine();
        employee.setName(sc.nextLine());

        System.out.println("Enter employee address: ");
        employee.setAddress(sc.nextLine());

        System.out.println("Enter employee salary: ");
        employee.setSalary(sc.nextInt());

        EmployeeDao ed = new EmployeeDaoImpl();
        try {
            Employee emp = ed.registerEmployee(employee);

            System.out.println("\nEmployee registered successfully!");
            System.out.println(emp);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }

    }

}
