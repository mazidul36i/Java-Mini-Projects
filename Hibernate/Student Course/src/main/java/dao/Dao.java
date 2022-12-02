package dao;

import bean.Course;
import bean.Student;
import exceptions.CourseException;
import exceptions.StudentException;

public interface Dao {

    public void addCourse(Course course);

    public void addStudent(Student student);

    public void getStudent(int roll_no) throws StudentException;

    public void getCourse(int course_id) throws CourseException;

}
