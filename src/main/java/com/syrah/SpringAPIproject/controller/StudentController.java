package com.syrah.SpringAPIproject.controller;

import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Students saveStudent(@RequestBody Students student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Students> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Students getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") Long StudentId){
        studentService.deleteStudentById(StudentId);
        return "Student deleted succesfully";
    }
}