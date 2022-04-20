package com.syrah.SpringAPIproject.service;


import com.syrah.SpringAPIproject.entity.Students;
import com.syrah.SpringAPIproject.errorhandling.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    public Students getStudentByFirstName(String fname);

    public Students saveStudent(Students student);

    public List<Students> getStudents();

    public Students getStudentById(Long studentId) throws StudentNotFoundException;

    public void deleteStudentById(Long studentId);

    public Students updateStudentDetail(Long studentId, Students student);

    public Students getStudentByLastName(String lname);
}
