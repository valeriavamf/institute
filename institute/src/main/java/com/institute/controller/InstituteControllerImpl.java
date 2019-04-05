package com.institute.controller;

import com.institute.model.Student;
import com.institute.model.Course;
import com.institute.services.CourseService;
import com.institute.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstituteControllerImpl implements InstituteController{

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Override
    @GetMapping("/students/all")
    public List<Student> retrieveAllStudents() {
        return studentService.retrieveAll();
    }

    @Override
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) throws Exception {
        return studentService.createStudent(student);
    }

    @Override
    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) throws Exception {
        return studentService.updateStudent(student,id);
    }

    @Override
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) throws Exception {
        return studentService.deleteStudent(id);
    }

    @Override
    @GetMapping("/students")
    public List<Student> retrieveStudents(  Long id,  String firstName, String lastName) throws Exception {
        return studentService.findStudent(id,lastName,firstName);
    }

    @Override
    @GetMapping("/student/courses")
    public List<Student> retrieveStudentsByCourse(String code,String title,String description) throws Exception {
        return studentService.findStudentsByCourse(code,title,description);
    }

    @Override
    @GetMapping("/courses/all")
    public List<Course> retrieveAllCourses() {
        return courseService.retrieveAll();
    }

    @Override
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) throws Exception {
        return courseService.createCourse(course);
    }

    @Override
    @PutMapping("/courses/{code}")
    public Course updateCourse(@RequestBody Course course,@PathVariable String code) throws Exception {
        return courseService.updateCourse(course,code);
    }

    @Override
    @DeleteMapping("/courses/{code}")
    public String deleteCourse(@PathVariable String code) throws Exception {
        return courseService.deleteCourse(code);
    }

    @Override
    @GetMapping("/courses")
    public List<Course> retrieveCourse( String code,  String title,  String description) throws Exception {
        return courseService.findCourse(code,title,description);
    }

    @Override
    @GetMapping("/courses/student")
    public List<Course> retrieveCourseByStudent( Long id,  String firstName,  String lastName) throws Exception {
        return courseService.findCourseByStudent(id,lastName,firstName);
    }

}