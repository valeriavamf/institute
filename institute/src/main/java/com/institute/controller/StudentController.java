package com.institute.controller;

import com.institute.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/institute/students")
public interface  StudentController {
    List<Student> retrieveAllStudents() throws Exception;

    Student createStudent(Student student) throws Exception;

    Student updateStudent(Student student,Long id) throws Exception;

    String deleteStudent(Long id) throws Exception;

    List<Student> retrieveStudents(Long id,String firstName,String lastName) throws Exception;

    List<Student> retrieveStudentsByCourse(String code,String title,String description) throws Exception;

}
