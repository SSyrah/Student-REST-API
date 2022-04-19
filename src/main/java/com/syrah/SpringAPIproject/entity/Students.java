package com.syrah.SpringAPIproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String studentName;
    private String studentAddress;
    private String className;
    private Long coursesAccomplished;
    private Long studentPoints;

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", className='" + className + '\'' +
                ", coursesAccomplished=" + coursesAccomplished +
                ", studentPoints=" + studentPoints +
                '}';
    }

    public Students() {
    }

    public Students(Long studentId, String studentName, String studentAddress, String className, Long coursesAccomplished, Long studentPoints) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.className = className;
        this.coursesAccomplished = coursesAccomplished;
        this.studentPoints = studentPoints;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Long getCoursesAccomplished() {
        return coursesAccomplished;
    }

    public void setCoursesAccomplished(Long coursesAccomplished) {
        this.coursesAccomplished = coursesAccomplished;
    }

    public Long getStudentPoints() {
        return studentPoints;
    }

    public void setStudentPoints(Long studentPoints) {
        this.studentPoints = studentPoints;
    }

}
