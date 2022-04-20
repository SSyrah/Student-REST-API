package com.syrah.SpringAPIproject.controller;

import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.errorhandling.StudentNotFoundException;
import com.syrah.SpringAPIproject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/students")
    public Students saveStudent(@Valid @RequestBody Students student){
        LOGGER.info("Inside saveStudent of StudentController");
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Students> getStudents(){
        LOGGER.info("Inside getStudents of StudentController");
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Students getStudentById(@PathVariable("id") Long id) throws StudentNotFoundException {
        LOGGER.info("Inside of getStudentById of StudentController");
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") Long StudentId){
        studentService.deleteStudentById(StudentId);
        return "Student deleted succesfully";
    }
    @PutMapping("/students/{id}")
    public Students updateStudentDetail(@PathVariable("id") Long studentId, @RequestBody Students student){
        return studentService.updateStudentDetail(studentId, student);
    }
    @GetMapping("/students/name/{fname}")
    public Students getStudentByName(@PathVariable("fname")String fname){
        return studentService.getStudentByFirstName(fname);
    }
    @GetMapping("/students/lname/{lname}")
    public Students getStudentByLastName(@PathVariable("lname") String lname){
        return studentService.getStudentByLastName(lname);
    }
}