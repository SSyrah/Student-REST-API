package com.syrah.SpringAPIproject.repository;

import com.syrah.SpringAPIproject.entity.Students;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Students student =
                Students.builder()
                        .studentFirstName("Ville")
                        .studentLastName("Anttonen")
                        .studentAddress("Matinkatu")
                        .coursesAccomplished(12L)
                        .studentPoints(12L)
                        .className("It-geeks")
                        .build();
        entityManager.persist(student);
    }

    //define test case for repository
    @Test
    public void whenFindById_thenReturnStudent(){

        Students student = studentRepository.findById(1L).get();
        assertEquals(student.getStudentFirstName(),"Ville");
    }
}