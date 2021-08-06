package com.scalan.schoolRegistrationSystem.dao.configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitializeConfig {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS students;");
            // Students...
            statement.executeUpdate(
                    "CREATE TABLE students("
                    + "id INTEGER Primary key AUTO_INCREMENT, "
                    + "first_name varchar(30) not null, "
                    + "last_name varchar(30) not null)"
            );
            statement.executeUpdate(
                    "INSERT INTO students "
                    + "(id, first_name, last_name) "
                    + "VALUES "
                    + "(1, 'Alex', 'Sco'),"
                    + "(2, 'John', 'Doe'),"
                    + "(3, 'Mari', 'Lui'),"
                    + "(4, 'Jill', 'Sun'),"
                    + "(5, 'Debi', 'Fox');"
            );

            // Courses
            statement.execute("DROP TABLE IF EXISTS courses;");
            statement.executeUpdate(
                    "CREATE TABLE courses("
                    + "id INTEGER Primary key AUTO_INCREMENT, "
                    + "name varchar(30) not null)"
            );
            statement.executeUpdate(
                    "INSERT INTO courses "
                    + "(id, name) "
                    + "VALUES "
                    + "(1, 'Java'),"
                    + "(2, 'PHP'),"
                    + "(3, 'JS'),"
                    + "(4, 'Python'),"
                    + "(5, '.NET'),"
                    + "(6, 'Bash'),"
                    + "(7, 'Linux'),"
                    + "(8, 'Windows'),"
                    + "(9, 'MacOS'),"
                    + "(10, 'Docker'),"
                    + "(11, 'AWS');"
            );
            
            // students_courses
            statement.execute("DROP TABLE IF EXISTS students_courses;");
            statement.executeUpdate(
                    "CREATE TABLE students_courses("
                    + "student_id integer not null, "
                    + "course_id integer not null)"
            );
            statement.executeUpdate(
                    "INSERT INTO students_courses "
                    + "(student_id, course_id) "
                    + "VALUES "
                    + "(1, 1),"
                    + "(1, 2),"
                    + "(1, 3);"
            );
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
