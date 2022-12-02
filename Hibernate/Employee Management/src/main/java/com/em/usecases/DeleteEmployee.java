package com.em.usecases;

import com.em.bean.Employee;
import com.em.dao.EmployeeDao;
import com.em.dao.EmployeeDaoImpl;
import com.em.exceptions.EmployeeException;

import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee id to delete: ");
        int empId = scanner.nextInt();

        EmployeeDao ed = new EmployeeDaoImpl();
        try {
            Employee employee = ed.deleteEmployeeById(empId);
            System.out.println("\nEmployee deleted successfully!");
            System.out.println(employee);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}
