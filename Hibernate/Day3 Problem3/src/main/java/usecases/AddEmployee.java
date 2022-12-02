package usecases;

import bean.Employee;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

import java.util.Scanner;

public class AddEmployee {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.println("Enter employee name: ");
        employee.setName(sc.next());

        System.out.println("Enter employee address: ");
        employee.setAddress(sc.next());

        System.out.println("Enter employee salary: ");
        employee.setSalary(sc.nextInt());

        EmployeeDao ed = new EmployeeDaoImpl();
        ed.save(employee);
    }
}
