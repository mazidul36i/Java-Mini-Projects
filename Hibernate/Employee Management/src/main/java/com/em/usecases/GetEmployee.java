package com.em.usecases;

import com.em.bean.Employee;
import com.em.dao.EmployeeDao;
import com.em.dao.EmployeeDaoImpl;
import com.em.exceptions.EmployeeException;

import java.util.Scanner;

public class GetEmployee {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter employee Id; ");
        int empId = sc.nextInt();

        EmployeeDao ed = new EmployeeDaoImpl();
        try {
            Employee employee = ed.getEmployeeById(empId);
            System.out.println(employee);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }

}
