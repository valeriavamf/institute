package com.institute.repository;

import com.institute.repository.entity.CourseEntity;

import java.util.List;

public interface CourseGenericRepository {

    List<CourseEntity> retrieveCourses(String code, String title, String description);

    List<CourseEntity> retrieveCourseByStudents(Long id, String firstName, String lastName);
}
