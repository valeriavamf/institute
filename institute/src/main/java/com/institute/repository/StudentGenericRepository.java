package com.institute.repository;

import com.institute.repository.entity.StudentEntity;

import java.util.List;

public interface StudentGenericRepository {
    List<StudentEntity> retrieveStudents(Long id, String firstName, String lastName);

    List<StudentEntity> retrieveStudentsByCourse(String code, String title, String description);
}
