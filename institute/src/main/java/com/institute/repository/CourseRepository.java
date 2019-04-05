package com.institute.repository;

import com.institute.repository.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository  extends CrudRepository<CourseEntity, String>, CourseGenericRepository {
    List<CourseEntity> findAll();
}
