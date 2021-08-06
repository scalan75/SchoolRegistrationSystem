package com.scalan.schoolRegistrationSystem.controller;

import com.scalan.schoolRegistrationSystem.dao.CoursesDao;
import com.scalan.schoolRegistrationSystem.model.Course;
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
public class CoursesControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    CoursesController coursesController;
    @Mock
    CoursesDao coursesDao;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(coursesController)
                .build();
    }
    
    @Test
    public void getAll() throws Exception {
        List<Course> courses = Arrays.asList(new Course("TestCourse"));
        Mockito.when(coursesDao.findAll()).thenReturn(courses);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/courses"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void getById() throws Exception {
        Optional<Course> course = Optional.of(new Course("TestCourse"));
        Mockito.when(coursesDao.findById(1l)).thenReturn(course);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/api/courses/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/courses/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }
}
