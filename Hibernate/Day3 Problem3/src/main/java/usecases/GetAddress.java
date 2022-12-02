package usecases;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

import java.util.Scanner;

public class GetAddress {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter empId: ");
        int empId = sc.nextInt();

        EmployeeDao ed = new EmployeeDaoImpl();

        String address = ed.getAddressOfEmployee(empId);
        System.out.println(address);

    }

}
