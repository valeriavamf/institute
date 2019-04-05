package com.institute.controller;

import com.institute.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/institute/courses")
public interface CourseController {

    List<Course> retrieveAllCourses()throws Exception;

    Course createCourse(Course student) throws Exception;

    Course updateCourse(Course student,String code) throws Exception;

    String deleteCourse(String code) throws Exception;

    List<Course> retrieveCourse(String code,String title,String description) throws Exception;

    List<Course> retrieveCourseByStudent( Long id,  String firstName,  String lastName) throws Exception;
}
