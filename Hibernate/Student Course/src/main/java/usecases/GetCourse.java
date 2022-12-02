package usecases;

import dao.Dao;
import dao.DaoImpl;
import exceptions.CourseException;
import exceptions.StudentException;

import java.util.Scanner;

public class GetCourse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter course ID: ");
        int cid = sc.nextInt();

        Dao dao = new DaoImpl();
        try {
            dao.getCourse(cid);
        } catch (CourseException e) {
            System.out.println(e.getMessage());
        }

    }
}
