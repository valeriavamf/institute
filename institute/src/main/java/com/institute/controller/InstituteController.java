package com.institute.controller;

import com.institute.model.Student;
import com.institute.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/institute")
public interface InstituteController {

    List<Student> retrieveAllStudents() throws Exception;

    Student createStudent(Student student) throws Exception;

    Student updateStudent(Student student,Long id) throws Exception;

    String deleteStudent(Long id) throws Exception;

    List<Student> retrieveStudents(Long id,String firstName,String lastName) throws Exception;

    List<Student> retrieveStudentsByCourse(String code,String title,String description) throws Exception;


    List<Course> retrieveAllCourses()throws Exception;

    Course createCourse(Course student) throws Exception;

    Course updateCourse(Course student,String code) throws Exception;

    String deleteCourse(String code) throws Exception;

    List<Course> retrieveCourse(String code,String title,String description) throws Exception;

    List<Course> retrieveCourseByStudent( Long id,  String firstName,  String lastName) throws Exception;
}
