package com.institute.controller;

import com.institute.model.Student;
import com.institute.services.CourseService;
import com.institute.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    @Override
    @GetMapping("/all")
    public List<Student> retrieveAllStudents() {
        return studentService.retrieveAll();
    }

    @Override
    @PostMapping
    public Student createStudent(@RequestBody Student student) throws Exception {
        return studentService.createStudent(student);
    }

    @Override
    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) throws Exception {
        return studentService.updateStudent(student,id);
    }

    @Override
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) throws Exception {
        return studentService.deleteStudent(id);
    }

    @Override
    @GetMapping
    public List<Student> retrieveStudents(  Long id,  String firstName, String lastName) throws Exception {
        return studentService.findStudent(id,lastName,firstName);
    }

    @Override
    @GetMapping("/courses")
    public List<Student> retrieveStudentsByCourse(String code,String title,String description) throws Exception {
        return studentService.findStudentsByCourse(code,title,description);
    }

}
