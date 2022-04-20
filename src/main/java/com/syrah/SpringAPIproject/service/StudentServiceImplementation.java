package com.syrah.SpringAPIproject.service;

import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.errorhandling.StudentNotFoundException;
import com.syrah.SpringAPIproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Students getStudentByFirstName(String fname) {
        return studentRepository.findBystudentFirstNameIgnoreCase(fname);
    }
    @Override
    public Students getStudentByLastName(String lname) {
        return studentRepository.findBystudentLastNameIgnoreCase(lname);
    }
    @Override
    public Students saveStudent(Students student) {
        return studentRepository.save(student);
    }
    @Override
    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students getStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Students> student =  studentRepository.findById(studentId);

        if(!student.isPresent()){
            throw new StudentNotFoundException("Student Not Found!");
        }
        return student.get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Students updateStudentDetail(Long studentId, Students student) {
        Students studentDB = studentRepository.findById(studentId).get();

        if (Objects.nonNull(student.getStudentFirstName()) &&
           !"".equalsIgnoreCase(student.getStudentFirstName())){
            studentDB.setStudentFirstName(student.getStudentFirstName());
        }
        if (Objects.nonNull(student.getStudentLastName()) &&
                !"".equalsIgnoreCase(student.getStudentLastName())){
            studentDB.setStudentLastName(student.getStudentLastName());
        }
        if (Objects.nonNull(student.getStudentAddress()) &&
                !"".equalsIgnoreCase(student.getStudentAddress())){
            studentDB.setStudentAddress(student.getStudentAddress());
        }
        if (Objects.nonNull(student.getStudentPoints())){
            studentDB.setStudentPoints(student.getStudentPoints());
        }
        if (Objects.nonNull(student.getClassName()) &&
                !"".equalsIgnoreCase(student.getClassName())){
            studentDB.setClassName(student.getClassName());
        }
        if (Objects.nonNull(student.getCoursesAccomplished())){
            studentDB.setCoursesAccomplished(student.getCoursesAccomplished());
        }
        return studentRepository.save(studentDB);
    }
}
