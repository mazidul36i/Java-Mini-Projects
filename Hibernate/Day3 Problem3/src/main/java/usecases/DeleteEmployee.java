package usecases;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter empId: ");
        int empId = sc.nextInt();

        EmployeeDao ed = new EmployeeDaoImpl();
        boolean isDeleted = ed.deleteEmployee(empId);

        if (isDeleted) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Failed to delete employee with id: " + empId);
        }
    }
}
