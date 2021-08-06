package com.scalan.schoolRegistrationSystem.controller;

import com.scalan.schoolRegistrationSystem.dao.CoursesDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scalan.schoolRegistrationSystem.model.Student;
import com.scalan.schoolRegistrationSystem.dao.StudentsDao;
import com.scalan.schoolRegistrationSystem.model.Course;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/api")
public class ReportsController {

    @Autowired
    private StudentsDao studentsDao;

    @Autowired
    private CoursesDao coursesDao;

    @GetMapping("/reports/course/{id}/students")
    public ResponseEntity<List<Student>> getCourseStudents(@PathVariable("id") long id) {
        Optional<Course> courseData = coursesDao.findById(id);

        if (courseData.isPresent()) {
            Course course = courseData.get();
            return new ResponseEntity<>(new ArrayList<Student>(course.getStudents()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reports/student/{id}/courses")
    public ResponseEntity<List<Course>> getStudentCourses(@PathVariable("id") long id) {
        Optional<Student> studentData = studentsDao.findById(id);

        if (studentData.isPresent()) {
            Student student = studentData.get();
            return new ResponseEntity<>(new ArrayList<Course>(student.getCourses()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/reports/studentsWithoutAnyCourses")
    public ResponseEntity<List<Student>> getStudentsWithoutAnyCourses() {
        try {
            List<Student> students = studentsDao.findAll().stream()
                    .filter(p -> p.getCourses().size() == 0)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/coursesWithoutAnyStudents")
    public ResponseEntity<List<Course>> getCoursesWithoutAnyCourses() {
        try {
            List<Course> courses = coursesDao.findAll().stream()
                    .filter(p -> p.getStudents().size() == 0)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
