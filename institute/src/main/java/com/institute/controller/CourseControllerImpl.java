package com.institute.controller;

import com.institute.model.Course;
import com.institute.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseControllerImpl implements CourseController{

    @Autowired
    private CourseService courseService;

    @Override
    @GetMapping("/all")
    public List<Course> retrieveAllCourses() {
        return courseService.retrieveAll();
    }

    @Override
    @PostMapping
    public Course createCourse(@RequestBody Course course) throws Exception {
        return courseService.createCourse(course);
    }

    @Override
    @PutMapping("/{code}")
    public Course updateCourse(@RequestBody Course course,@PathVariable String code) throws Exception {
        return courseService.updateCourse(course,code);
    }

    @Override
    @DeleteMapping("/{code}")
    public String deleteCourse(@PathVariable String code) throws Exception {
        return courseService.deleteCourse(code);
    }

    @Override
    @GetMapping
    public List<Course> retrieveCourse( String code,  String title,  String description) throws Exception {
        return courseService.findCourse(code,title,description);
    }

    @Override
    @GetMapping("/students")
    public List<Course> retrieveCourseByStudent( Long id,  String firstName,  String lastName) throws Exception {
        return courseService.findCourseByStudent(id,lastName,firstName);
    }

}
