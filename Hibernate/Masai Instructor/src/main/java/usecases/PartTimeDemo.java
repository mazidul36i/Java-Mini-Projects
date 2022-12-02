package usecases;

import bean.FullTimeInstructor;
import bean.PartTimeInstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PartTimeDemo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Instructor");
        EntityManager manager = emf.createEntityManager();

        Query query = manager.createQuery("FROM PartTimeInstructor");
        List<PartTimeInstructor> instructors = query.getResultList();

        if (instructors.size() == 0) {
            System.out.println("No Instructors found!");
        } else {
            instructors.forEach(System.out::println);
        }

        manager.close();

    }
}
