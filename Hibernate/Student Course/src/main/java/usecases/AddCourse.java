package usecases;

import bean.Course;
import bean.Student;
import dao.Dao;
import dao.DaoImpl;

import java.util.Scanner;

public class AddCourse {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Course course = new Course();

        System.out.println("Enter course name: ");
        course.setCourseName(sc.nextLine());

        System.out.println("Enter course duration: ");
        course.setDuration(sc.nextLine());

        System.out.println("Enter course fee: ");
        course.setFee(sc.nextInt());

        Dao dao = new DaoImpl();
        dao.addCourse(course);
        System.out.println("Course added successfully!");

    }
}
