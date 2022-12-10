package com.masai;

import com.masai.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DBConnect dbConnect = ctx.getBean("dbconnect", DBConnect.class);

        try (Connection connection = dbConnect.getConnection()) {
            Student student = new Student("name", 22, 485);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO Student (name, roll, marks) VALUES (?, ?, ?)");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getRoll());
            ps.setInt(3, student.getMarks());

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Student inserted successfully!");
            } else {
                System.out.println("Failed to insert student..!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
