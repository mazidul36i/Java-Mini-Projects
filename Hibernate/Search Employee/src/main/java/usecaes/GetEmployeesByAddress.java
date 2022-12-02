package usecaes;

import bean.Employee;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exceptions.EmployeeException;

import java.util.List;

public class GetEmployeesByAddress {

    public static void main(String[] args) {

        List<Employee> employees;
        EmployeeDao ed = new EmployeeDaoImpl();
        try {
            employees = ed.getEmployeesByAddress("Barpeta Road");
            System.out.println("Employee data loaded successfully!");
            employees.forEach(System.out::println);
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }

    }

}
