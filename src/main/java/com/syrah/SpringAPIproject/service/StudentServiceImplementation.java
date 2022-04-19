package com.syrah.SpringAPIproject.service;

import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Students saveStudent(Students student) {
        return studentRepository.save(student);
    }
    @Override
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Students getStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
