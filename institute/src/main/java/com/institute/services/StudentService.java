package com.institute.services;

import com.institute.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> retrieveAll();

    Student updateStudent(Student student, Long id);

    String deleteStudent(Long studentId);

    List<Student> findStudent(Long studentId, String lastName, String firstName);

    List<Student> findStudentsByCourse(String code, String title, String description);
}
