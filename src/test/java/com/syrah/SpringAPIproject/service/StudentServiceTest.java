package com.syrah.SpringAPIproject.service;

import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Students student =
                Students.builder()
                        .studentFirstName("Antti")
                        .studentLastName("Vikman")
                        .studentAddress("Kaalikatu 12")
                        .coursesAccomplished(3L)
                        .studentPoints(12L)
                        .className("TiTe")
                        .build();
                Mockito.when(studentRepository.findBystudentFirstNameIgnoreCase
                        ("Antti")).thenReturn(student);
    }
    // Unit testing for service layer
    @Test
    @DisplayName("Get Data based on Valid Student Name")
    @Disabled()
    public void whenValidStudentFirstName_thenStudentShouldBeFound(){
        String studentName = "Antti";
        Students found = studentService.getStudentByFirstName(studentName);
        assertEquals(studentName, found.getStudentFirstName());

    }
}