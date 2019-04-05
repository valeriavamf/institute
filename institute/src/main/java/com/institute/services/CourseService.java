package com.institute.services;

import com.institute.model.Course;
import com.institute.model.Student;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course) throws Exception;

    List<Course> retrieveAll();

    Course updateCourse(Course course, String id);

    String deleteCourse(String studentId);

    List<Course> findCourse(String code, String title, String description);

    List<Course> findCourseByStudent(Long id, String lastName, String firstName);

}
