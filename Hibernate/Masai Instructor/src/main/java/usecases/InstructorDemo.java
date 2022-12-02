package usecases;

import bean.FullTimeInstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class InstructorDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Instructor");
        EntityManager manager = emf.createEntityManager();

        System.out.println("Enter Instructor Id: ");
        int x = sc.nextInt();

        Query query = manager.createQuery("FROM FullTimeInstructor f WHERE f.instructorId= :id");
        query.setParameter("id", x);

        try {
            FullTimeInstructor instructor = (FullTimeInstructor) query.getSingleResult();
            System.out.println(instructor);
        } catch (Exception e) {
            System.out.println("No FullTimeInstructor found with id= " + x);
        }

        manager.close();
    }
}
