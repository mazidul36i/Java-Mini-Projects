package com.em.usecases;

import com.em.bean.Employee;
import com.em.dao.EmployeeDao;
import com.em.dao.EmployeeDaoImpl;
import com.em.exceptions.EmployeeException;

import java.util.Scanner;

public class UpdateEmployee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();
        System.out.println("Enter the employee Id: ");
        employee.setEmpId(scanner.nextInt());

        System.out.println("Enter new employee name (or leave empty to ignore): ");
        scanner.nextLine();
        String name = scanner.nextLine();
        if (!name.equals(""))
            employee.setName(name);

        System.out.println("Enter new employee address (or leave empty to ignore): ");
        String address = scanner.nextLine();
        if (!address.equals(""))
            employee.setAddress(address);

        System.out.println("Enter employee salary (or leave -1 to ignore): ");
        int salary = scanner.nextInt();
        if (salary != 0)
            employee.setSalary(salary);

        EmployeeDao ed = new EmployeeDaoImpl();
        try {
            Employee employee1 = ed.updateEmployee(employee);
            System.out.println("Employee details updated successfully!");
            System.out.println(employee1);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }

    }
}
