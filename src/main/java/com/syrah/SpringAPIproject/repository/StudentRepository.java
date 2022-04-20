package com.syrah.SpringAPIproject.repository;

import com.syrah.SpringAPIproject.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
    public Students findBystudentFirstName(String studentName);

    public Students findBystudentFirstNameIgnoreCase(String studentName);

    public Students findBystudentLastNameIgnoreCase(String lname);
}
