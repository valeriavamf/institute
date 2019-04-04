package com.institute.services;

import com.institute.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> retrieveAll();
    Course updateCourse(Course course);
    Course deleteCourse(String studentId);
    List<Course> findStudent(String code, String title, String description);
}
