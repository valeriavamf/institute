package com.institute.services;

import com.institute.model.Course;
import com.institute.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoureseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return null;
    }

    @Override
    public List<Course> retrieveAll() {
        return null;
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }

    @Override
    public Course deleteCourse(String studentId) {
        return null;
    }

    @Override
    public List<Course> findStudent(String code, String title, String description) {
        return null;
    }
}
