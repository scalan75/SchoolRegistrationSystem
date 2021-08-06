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
public class StudentsControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    StudentsController studentsController;
    @Mock
    StudentsDao studentsDao;
    @Mock
    CoursesDao coursesDao;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(studentsController)
                .build();
    }
    
    @Test
    public void getAll() throws Exception {
        List<Student> students = Arrays.asList(new Student("FName", "LName"));
        Mockito.when(studentsDao.findAll()).thenReturn(students);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getById() throws Exception {
        Optional<Student> student = Optional.of(new Student("FName", "LName"));
        Mockito.when(studentsDao.findById(1l)).thenReturn(student);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/students/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }
    
    @Test
    public void register() throws Exception {
        Optional<Student> student = Optional.of(new Student("FName", "LName"));
        Mockito.when(studentsDao.findById(1l)).thenReturn(student);
        Optional<Course> course = Optional.of(new Course("Test course"));
        Mockito.when(coursesDao.findById(1l)).thenReturn(course);
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/students/1/register/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
