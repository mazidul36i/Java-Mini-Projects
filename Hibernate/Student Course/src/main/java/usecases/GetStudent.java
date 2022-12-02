package usecases;

import bean.Course;
import bean.Student;
import dao.Dao;
import dao.DaoImpl;
import exceptions.StudentException;

import java.util.Scanner;

public class GetStudent {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.println("Enter student roll no: ");
        int roll = sc.nextInt();

        Dao dao = new DaoImpl();
        try {
            dao.getStudent(roll);
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }

    }
}
