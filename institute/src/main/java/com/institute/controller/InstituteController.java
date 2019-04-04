package com.institute.controller;

import com.institute.model.Student;
import com.institute.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/institute")
public interface InstituteController {

    List<Student> retrieveAllStudents() throws Exception;

    List<Course> retrieveAllCourses()throws Exception;
}
