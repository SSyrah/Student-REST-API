package com.syrah.SpringAPIproject.service;


import com.syrah.SpringAPIproject.entity.Students;

import java.util.List;

public interface StudentService {

    public Students saveStudent(Students student);

    public List<Students> getStudents();

    public Students getStudentById(Long studentId);

    public void deleteStudentById(Long studentId);
}
