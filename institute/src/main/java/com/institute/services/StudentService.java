package com.institute.services;

import com.institute.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    List<Student> retrieveAll();
    Student updateStudent(Student student);
    Student deleteStudent(Long studentId);
    List<Student> findStudent(Long studentId, String lastName, String firstName);
}
