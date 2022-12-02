package dao;

import bean.Course;
import bean.Student;
import exceptions.CourseException;
import exceptions.StudentException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoImpl implements Dao {

    static EntityManagerFactory emf;
    static EntityManager manager;

    static {
        emf = Persistence.createEntityManagerFactory("Student");
        manager = emf.createEntityManager();
    }

    @Override
    public void addCourse(Course course) {
        manager.getTransaction().begin();
        manager.persist(course);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void addStudent(Student student) {
        manager.getTransaction().begin();
        manager.persist(student);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void getStudent(int roll_no) throws StudentException {
        Student student = manager.find(Student.class, roll_no);
        manager.close();

        if (student == null) throw new StudentException("No student found!");
        System.out.println(student);
    }

    @Override
    public void getCourse(int course_id) throws CourseException {
        Course course = manager.find(Course.class, course_id);
        manager.close();

        if (course == null) throw new CourseException("No course found!");
        System.out.println(course);
    }
}
