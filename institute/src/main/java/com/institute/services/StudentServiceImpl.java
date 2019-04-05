package com.institute.services;

import com.institute.model.Student;
import com.institute.repository.StudentRepository;
import com.institute.repository.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student createStudent(Student student) {
        if (student == null)
            return null;
        student.setId(null);
        StudentEntity entity = studentRepository.save(student.retrieveEntity());
        return new Student().retrieveModel(entity);
    }

    @Override
    public List<Student> retrieveAll() {
        List<StudentEntity> allStudents = studentRepository.findAll();
        List<Student> result = new ArrayList<>();
        if (allStudents == null)
            return result;
        allStudents.forEach(entity -> result.add(new Student().retrieveModel(entity)));
        return result;
    }

    @Override
    public Student updateStudent(Student student, Long id) {

        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId == null)
            return null;

        StudentEntity entity = byId.get();
        StudentEntity newEntity = student.retrieveEntity();
        entity.setLastName(newEntity.getLastName());
        entity.setFirstName(newEntity.getFirstName());
        entity.setCourses(newEntity.getCourses());
        StudentEntity save = studentRepository.save(entity);
        if (save == null)
            return null;
        return new Student().retrieveModel(save);
    }

    @Override
    public String deleteStudent(Long studentId) {
        Optional<StudentEntity> byId = studentRepository.findById(studentId);
        if (byId == null)
            return "student not founnd";
        try{
            studentRepository.deleteById(studentId);
        }catch (Exception ex){
            return ex.getMessage();
        }
        return "student deleted";
    }

    @Override
    public List<Student> findStudent(Long studentId, String lastName, String firstName) {

        List<Student> result = new ArrayList<>();

        List<StudentEntity> studentEntities = studentRepository.retrieveStudents(studentId, firstName, lastName);

        if (studentEntities == null)
            return result;

        studentEntities.forEach(entity -> result.add(new Student().retrieveModel(entity)));

        return result;
    }

    @Override
    public List<Student> findStudentsByCourse(String code, String title, String description) {

        List<Student> result = new ArrayList<>();

        List<StudentEntity> studentEntities = studentRepository.retrieveStudentsByCourse(code, title, description);

        if (studentEntities == null)
            return result;

        studentEntities.forEach(entity -> result.add(new Student().retrieveModel(entity)));

        return result;
    }
}
