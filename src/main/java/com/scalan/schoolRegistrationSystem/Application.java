package com.scalan.schoolRegistrationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static final int COURSES_LIMIT = 5;
    public static final int STUDENTS_LIMIT = 50;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
