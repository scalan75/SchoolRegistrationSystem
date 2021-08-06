package com.scalan.schoolRegistrationSystem.controller;

import com.scalan.schoolRegistrationSystem.dao.CoursesDao;
import com.scalan.schoolRegistrationSystem.dao.StudentsDao;
import com.scalan.schoolRegistrationSystem.model.Course;
import com.scalan.schoolRegistrationSystem.model.Student;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class ReportsControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    ReportsController reportsController;
    @Mock
    StudentsDao studentsDao;
    @Mock
    CoursesDao coursesDao;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(reportsController)
                .build();
    }
    
    @Test
    public void getCourseStudents() throws Exception {
        Student testStudent = new Student("FName", "LName");
        Course testCourse = new Course("Test course");
        testStudent.getCourses().add(testCourse);
        
        Optional<Student> student = Optional.of(testStudent);
        Mockito.when(studentsDao.findById(1l)).thenReturn(student);
        Optional<Course> course = Optional.of(testCourse);
        Mockito.when(coursesDao.findById(1l)).thenReturn(course);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reports/course/1/students"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getStudentCourses() throws Exception {
        Student testStudent = new Student("FName", "LName");
        Course testCourse = new Course("Test course");
        testStudent.getCourses().add(testCourse);
        
        Optional<Student> student = Optional.of(testStudent);
        Mockito.when(studentsDao.findById(1l)).thenReturn(student);
        Optional<Course> course = Optional.of(testCourse);
        Mockito.when(coursesDao.findById(1l)).thenReturn(course);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reports/student/1/courses"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getStudentsWithoutAnyCourses() throws Exception {
        List<Student> students = Arrays.asList(new Student("FName", "LName"));
        Mockito.when(studentsDao.findAll()).thenReturn(students);
        Optional<Course> course = Optional.of(new Course("Test course"));
        Mockito.when(coursesDao.findById(1l)).thenReturn(course);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reports/studentsWithoutAnyCourses"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getCoursesWithoutAnyStudents() throws Exception {
        List<Student> students = Arrays.asList(new Student("FName", "LName"));
        Mockito.when(studentsDao.findAll()).thenReturn(students);
        Optional<Course> course = Optional.of(new Course("Test course"));
        Mockito.when(coursesDao.findById(1l)).thenReturn(course);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reports/coursesWithoutAnyStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
