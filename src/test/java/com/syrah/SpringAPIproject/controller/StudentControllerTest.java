package com.syrah.SpringAPIproject.controller;

import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.errorhandling.StudentNotFoundException;
import com.syrah.SpringAPIproject.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Students student;

    @BeforeEach
    void setUp(){
        student = Students.builder()
                .studentFirstName("ville")
                .studentLastName("markkanen")
                .studentAddress("Antinkuja 12")
                .coursesAccomplished(8L)
                .studentPoints(22L)
                .studentId(1L)
                .build();
    }

    @Test
    void saveStudent() throws Exception {
       Students inputStudent = Students.builder()
                .studentFirstName("ville")
                .studentLastName("markkanen")
                .studentAddress("Antinkuja 12")
                .coursesAccomplished(8L)
                .studentPoints(22L)
                .build();

       Mockito.when(studentService.saveStudent(inputStudent)).thenReturn(student);

       mockMvc.perform(post("/students")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\n" +
                       "\t\"studentFirstName\": \"ville\",\n" +
                       "\t\"studentLastName\": \"markkanen\",\n" +
                       "\t\"studentAddress\": \"Antinkuja 12\",\n" +
                       "\t\"coursesAccomplished\": 8,\n" +
                       "\t\"studentPoints\": 22\n" +
                       "}"))
               .andExpect(status().isOk());


    }

    @Test
    void getStudentById() throws Exception {
        Mockito.when(studentService.getStudentById(1L)).thenReturn(student);

        mockMvc.perform(get("/students/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentFirstName").value(student.getStudentFirstName()));

    }
}