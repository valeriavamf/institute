package com.institute.services;

import com.institute.model.Student;
import com.institute.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student createStudent(Student student) {
        return null;
    }

    @Override
    public List<Student> retrieveAll() {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(Long studentId) {
        return null;
    }

    @Override
    public List<Student> findStudent(Long studentId, String lastName, String firstName) {
        return null;
    }
}
