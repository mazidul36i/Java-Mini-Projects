package usecases;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

import java.util.Scanner;

public class GiveBonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter empId: ");
        int empId = sc.nextInt();

        System.out.println("Enter bonus amount: ");
        int bonus = sc.nextInt();

        EmployeeDao ed = new EmployeeDaoImpl();
        String output = ed.giveBonusToEmployee(empId, bonus);

        System.out.println(output);

    }

}
