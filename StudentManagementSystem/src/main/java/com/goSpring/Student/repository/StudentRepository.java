package com.goSpring.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goSpring.Student.entity.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{

}
