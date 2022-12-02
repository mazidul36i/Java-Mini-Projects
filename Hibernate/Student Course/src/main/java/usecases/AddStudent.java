package usecases;

import bean.Student;
import dao.Dao;
import dao.DaoImpl;

import java.util.Scanner;

public class AddStudent {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Student student = new Student();

        System.out.println("Enter student name: ");
        student.setName(sc.nextLine());

        System.out.println("Enter student email: ");
        student.setEmail(sc.next());

        System.out.println("Enter student phone: ");
        student.setMobile(sc.next());

        System.out.println("Enter student course ID: ");
        student.setCourseId(sc.nextInt());

        Dao dao = new DaoImpl();
        dao.addStudent(student);
        System.out.println("Student added successfully!");

    }
}
