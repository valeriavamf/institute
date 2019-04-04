package com.institute.controller;

import com.institute.model.Student;
import com.institute.model.Course;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstituteControllerImpl implements InstituteController{

    @Override
    public List<Student> retrieveAllStudents() {
        return null;
    }

    @Override
    public List<Course> retrieveAllCourses() {
        return null;
    }

}