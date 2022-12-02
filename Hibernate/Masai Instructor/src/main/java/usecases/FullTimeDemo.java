package usecases;

import bean.FullTimeInstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FullTimeDemo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Instructor");
        EntityManager manager = emf.createEntityManager();

        Query query = manager.createQuery("FROM FullTimeInstructor");
        List<FullTimeInstructor> instructors = query.getResultList();

        if (instructors.size() == 0) {
            System.out.println("No Instructors found!");
        } else {
            instructors.forEach(System.out::println);
        }

        manager.close();

    }
}
