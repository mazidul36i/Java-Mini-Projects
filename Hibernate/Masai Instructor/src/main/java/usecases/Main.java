package usecases;

import bean.FullTimeInstructor;
import bean.PartTimeInstructor;
import jdk.jfr.Percentage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Instructor");
        EntityManager manager = emf.createEntityManager();

        {
            FullTimeInstructor instructor = new FullTimeInstructor();
            instructor.setInstructorName("FI1");
            instructor.setEmail("fi1@email.com");
            instructor.setSalary(78432);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }
        {
            FullTimeInstructor instructor = new FullTimeInstructor();
            instructor.setInstructorName("FI2");
            instructor.setEmail("fi2@email.com");
            instructor.setSalary(2839);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }
        {
            FullTimeInstructor instructor = new FullTimeInstructor();
            instructor.setInstructorName("FI3");
            instructor.setEmail("fi3@email.com");
            instructor.setSalary(57389);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }
        {
            FullTimeInstructor instructor = new FullTimeInstructor();
            instructor.setInstructorName("FI4");
            instructor.setEmail("fi4@email.com");
            instructor.setSalary(76834);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }

// Part Time
        {
            PartTimeInstructor instructor = new PartTimeInstructor();
            instructor.setInstructorName("PI1");
            instructor.setCostPerSession(6732);
            instructor.setMobileNumber("3784563478");
            instructor.setNoOfSession(2);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }
        {
            PartTimeInstructor instructor = new PartTimeInstructor();
            instructor.setInstructorName("PI2");
            instructor.setCostPerSession(4638);
            instructor.setMobileNumber("7392857348");
            instructor.setNoOfSession(1);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }
        {
            PartTimeInstructor instructor = new PartTimeInstructor();
            instructor.setInstructorName("PI3");
            instructor.setCostPerSession(5348);
            instructor.setMobileNumber("54782935343");
            instructor.setNoOfSession(2);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }
        {
            PartTimeInstructor instructor = new PartTimeInstructor();
            instructor.setInstructorName("PI4");
            instructor.setCostPerSession(5438);
            instructor.setMobileNumber("58349679384");
            instructor.setNoOfSession(2);

            manager.getTransaction().begin();
            manager.persist(instructor);
            manager.getTransaction().commit();
        }

        System.out.println("Instructors added successfully!");
        manager.close();
    }

}
