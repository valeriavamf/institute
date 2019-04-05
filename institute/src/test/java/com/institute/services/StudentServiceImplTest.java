package com.institute.services;

import com.institute.model.Student;
import com.institute.repository.StudentRepository;
import com.institute.repository.entity.StudentEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl service;

    private Student student = new Student();
    private StudentEntity entity = new StudentEntity();


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        student.setId(1L);
        student.setFirstName("name");
        student.setLastName("last");

        entity.setId(1L);
        entity.setFirstName("name");
        entity.setLastName("last");
    }

    @Test
    public void createStudent_CheckStudentIsSave() throws Exception {

        when(studentRepository.save(isA(StudentEntity.class))).thenReturn(entity);

        Student result = service.createStudent(student);

        assertNotNull(result);
        assertEquals(result.getFirstName(), student.getFirstName());

    }

    @Test
    public void retrieveAll_CheckStudentAreRetrived() throws Exception {

        when(studentRepository.findAll()).thenReturn(Arrays.asList(entity));

        List<Student> result = service.retrieveAll();

        assertNotNull(result);
        assertEquals(result.size(),1);

    }

    @Test
    public void retrieveAll_CheckStudentisEmptyWhenThereIsNoData() throws Exception {

        when(studentRepository.findAll()).thenReturn(null);

        List<Student> result = service.retrieveAll();

        assertNotNull(result);
        assertEquals(result.size(),0);

    }

    @Test
    public void deleteStudent_CheckStudentIsDeleted() throws Exception {
        long id = 1;

        Optional<StudentEntity> studentEntity = Optional.of(entity);

        when(studentRepository.findById(id)).thenReturn(studentEntity);

        String result = service.deleteStudent(id);

        assertNotNull(result);
        assertEquals(result,"student deleted");

    }

    @Test
    public void deleteStudent_CheckStudentIsNotDeleted() throws Exception {

        when(studentRepository.findById(1L)).thenReturn(null);

        String result = service.deleteStudent(1L);

        assertNotNull(result);
        assertEquals(result,"student not founnd");

    }

    @Test
    public void updateStudent_CheckStudentIsSave() throws Exception {
        entity.setFirstName("desc2");

        Optional<StudentEntity> optionalStudent = Optional.of(entity);

        when(studentRepository.findById(student.getId())).thenReturn(optionalStudent);

        when(studentRepository.save(isA(StudentEntity.class))).thenReturn(entity);

        Student result = service.updateStudent(student,student.getId());

        assertNotNull(result);
        assertEquals(result.getFirstName(),student.getFirstName());

    }
}